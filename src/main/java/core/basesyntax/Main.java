package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.operationstrategy.OperationStrategyImpl;
import core.basesyntax.operationstrategy.handler.BalanceOperationHandler;
import core.basesyntax.operationstrategy.handler.OperationHandler;
import core.basesyntax.operationstrategy.handler.PurchaseOperationHandler;
import core.basesyntax.operationstrategy.handler.ReturnOperationHandler;
import core.basesyntax.operationstrategy.handler.SupplyOperationHandler;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.DataProcessor;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Operation, OperationHandler> operation = Map.of(
                Operation.BALANCE, new BalanceOperationHandler(),
                Operation.RETURN, new ReturnOperationHandler(),
                Operation.PURCHASE, new PurchaseOperationHandler(),
                Operation.SUPPLY, new SupplyOperationHandler());
        FileReaderService csvFileReader = new CsvFileReaderService();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operation);
        DataProcessor dataProcessor = new DataProcessor(operationStrategy);
        FileWriterService csvFileWriter = new CsvFileWriterService();

        String dataFromFile = csvFileReader
                .readDataFromFile("src/main/resources/data.csv");
        String processedData = dataProcessor.processData(dataFromFile);
        csvFileWriter
                .writeDataToFile(processedData, "src/main/resources/processedData.csv");
    }
}
