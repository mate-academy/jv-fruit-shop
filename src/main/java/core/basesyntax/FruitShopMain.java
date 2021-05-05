package core.basesyntax;

import core.basesyntax.files.FileReader;
import core.basesyntax.files.FileReaderImpl;
import core.basesyntax.files.FileWriter;
import core.basesyntax.files.FileWriterImpl;
import core.basesyntax.files.FruitRecordDtoParser;
import core.basesyntax.files.FruitRecordDtoParserImpl;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Operation;
import core.basesyntax.service.impl.AddOperation;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.PurchaseOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopMain {
    private static final String FILE_PATH = "src/main/resources/shop_operation.csv";
    private static final String REPORT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, FruitOperationHandler> operationsExamples = new HashMap<>();
        operationsExamples.put(Operation.BALANCE, new AddOperation());
        operationsExamples.put(Operation.SUPPLY, new AddOperation());
        operationsExamples.put(Operation.RETURN, new AddOperation());
        operationsExamples.put(Operation.PURCHASE, new PurchaseOperation());

        FileReader fileReader = new FileReaderImpl();
        List<String> dataFromFile = fileReader.readFromFile(FILE_PATH);

        FruitRecordDtoParser fruitRecordDtoParser = new FruitRecordDtoParserImpl();
        List<FruitRecordDto> fruitRecordDtoList = fruitRecordDtoParser.parseStrings(dataFromFile);

        FruitService fruitService = new FruitServiceImpl(operationsExamples);
        fruitService.applyOperation(fruitRecordDtoList);

        String report = fruitService.getFruitReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.createReport(report, REPORT_PATH);
    }
}
