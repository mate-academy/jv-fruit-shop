package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.GeneratingReportServiceImpl;
import core.basesyntax.service.impl.ProcessingFileDataServiceImpl;
import core.basesyntax.service.impl.ReadingFileServiceImpl;
import core.basesyntax.service.impl.WritingFileServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String INPUT_FILE = "src/main/resources/fruits_data.csv";
    private static final String OUTPUT_FILE = "src/main/resources/fruits_report.csv";

    public static void main(String[] args) {
        // reading file
        ReadingFileServiceImpl readingFileService = new ReadingFileServiceImpl();
        List<String> fileLines = readingFileService.readingDataFromFile(INPUT_FILE);
        // translate strings into a fieldset
        ProcessingFileDataServiceImpl processingFileDataService = new ProcessingFileDataServiceImpl();
        List<FruitTransaction> fruitTransactions = processingFileDataService.processingFileData(fileLines);
        // creating strategy map
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        // filling the strategy with data
        OperationStrategyImpl operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler = operationStrategy
                    .get(fruitTransaction.getOperation());
            operationHandler.applyTransactionToStorage(fruitTransaction);
        }
        // preparing final report
        GeneratingReportServiceImpl generatingReportService = new GeneratingReportServiceImpl();
        String generateReport = generatingReportService.generateReport();
        // writing report to file
        WritingFileServiceImpl writingFileService = new WritingFileServiceImpl();
        writingFileService.writingDataToFile(generateReport, OUTPUT_FILE);
    }
}
