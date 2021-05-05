package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitRecordParser;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.AddOperationHandler;
import core.basesyntax.service.impl.BalanceOperationHandler;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitRecordParserImpl;
import core.basesyntax.service.impl.ReportServiceCsv;
import core.basesyntax.service.impl.SubtractOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/java/core/basesyntax/resources/fruitsFrom";
    private static final String OUTPUT_FILE = "src/main/java/core/basesyntax/resources/report.csv";
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String RETURN = "r";
    private static final String PURCHASE = "p";

    public static void main(String[] args) {
        Map<String, OperationHandler> map = new HashMap<>();
        map.put(BALANCE, new BalanceOperationHandler());
        map.put(SUPPLY, new AddOperationHandler());
        map.put(RETURN, new AddOperationHandler());
        map.put(PURCHASE, new SubtractOperationHandler());

        FileReaderService fileReader = new FileReaderImpl();
        FruitRecordParser fruitRecordParser = new FruitRecordParserImpl();
        List<FruitRecordDto> dtos = fruitRecordParser.parse(fileReader.readFromFile(INPUT_FILE));
        for (FruitRecordDto dto : dtos) {
            map.get(dto.getOperationType()).apply(dto);
        }
        ReportService reportMaker = new ReportServiceCsv();
        FileWriterService fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(reportMaker.createReport(Storage.fruits), OUTPUT_FILE);
    }
}
