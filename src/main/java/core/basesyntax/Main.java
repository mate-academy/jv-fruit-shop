package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverterService;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.impl.CsvFileReaderService;
import core.basesyntax.service.impl.CsvFileWriterService;
import core.basesyntax.service.impl.FruitShopDataProcessingService;
import core.basesyntax.service.impl.FruitTransactionDataConverterService;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String DEFAULT_PATH = "src/main/resources/";
    private static final String INPUT_FILE_NAME = "input.csv";
    private static final Map<Operation, OperationHandler> operationHandlerMap = Map.of(
            Operation.BALANCE, new BalanceOperationHandler(),
            Operation.SUPPLY, new SupplyOperationHandler(),
            Operation.PURCHASE, new PurchaseOperationHandler(),
            Operation.RETURN, new ReturnOperationHandler());

    public static void main(String[] args) {
        File file = new File(DEFAULT_PATH + INPUT_FILE_NAME);
        FileReaderService fileReader = new CsvFileReaderService();
        String dataFromCsvFile = fileReader.readFromFile(file);
        DataConverterService dataConverter = new FruitTransactionDataConverterService();
        List<FruitTransaction> transactions = dataConverter.convertDataToObjects(dataFromCsvFile);
        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);
        DataProcessingService dataProcessing = new FruitShopDataProcessingService(strategy);
        dataProcessing.processData(transactions);
        ReportCreatorService reportCreator = new ReportCreatorServiceImpl();
        String report = reportCreator.createReport();
        FileWriterService fileWriter = new CsvFileWriterService();
        fileWriter.writeToFile(DEFAULT_PATH, report);
    }
}
