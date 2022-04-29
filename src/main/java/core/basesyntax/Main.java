package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ParserDataService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ParserDataServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.strategy.BalanceOperationService;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.PurchaseOperationService;
import core.basesyntax.strategy.ReturnOperationService;
import core.basesyntax.strategy.SupplyOperationService;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/database.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {

        Map<FruitTransaction.Operation, OperationService> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE,new BalanceOperationService());
        handlerMap.put(FruitTransaction.Operation.PURCHASE,new PurchaseOperationService());
        handlerMap.put(FruitTransaction.Operation.RETURN,new ReturnOperationService());
        handlerMap.put(FruitTransaction.Operation.SUPPLY,new SupplyOperationService());

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> read = fileReaderService.read(Path.of(INPUT_FILE_NAME));

        ParserDataService parserDataService = new ParserDataServiceImpl();
        List<FruitTransaction> parsedData = parserDataService.parse(read);

        for (FruitTransaction transaction : parsedData) {
            handlerMap.get(transaction.getOperation()).proceed(transaction);
        }

        ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl();
        String report = reportGeneratorService.report();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.write(Path.of(REPORT_FILE_NAME), report);

    }
}
