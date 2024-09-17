package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.DataReaderService;
import core.basesyntax.service.impl.FruitDataParser;
import core.basesyntax.service.impl.FruitDataReaderService;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.service.operations.impl.BalanceOperationHandler;
import core.basesyntax.service.operations.impl.PurchaseOperationHandler;
import core.basesyntax.service.operations.impl.ReturnOperationHandler;
import core.basesyntax.service.operations.impl.SupplyOperationHandler;
import core.basesyntax.service.operations.report.impl.FileWriterImpl;
import core.basesyntax.service.operations.report.impl.ReportGeneratorImpl;
import core.basesyntax.service.strategy.Operation;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.TransactionProcessor;
import core.basesyntax.service.strategy.impl.OperationStrategyImpl;
import core.basesyntax.service.strategy.impl.TransactionProcessorImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String reportPath = "src/main/resources/report";
    private static final String inputPath = "src/main/resources/input";

    public static void main(String[] args) {
        Storage storage = new Storage();
        BalanceOperationHandler balanceOperationHandler = new BalanceOperationHandler(storage);
        PurchaseOperationHandler purchaseOperationHandler = new PurchaseOperationHandler(storage);
        ReturnOperationHandler returnOperationHandler = new ReturnOperationHandler(storage);
        SupplyOperationHandler supplyOperationHandler = new SupplyOperationHandler(storage);

        Map<Operation, OperationHandler> handlersMap = Map.of(
                Operation.BALANCE, balanceOperationHandler,
                Operation.PURCHASE, purchaseOperationHandler,
                Operation.RETURN, returnOperationHandler,
                Operation.SUPPLY, supplyOperationHandler
        );
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlersMap);

        DataReaderService dataReaderService = new FruitDataReaderService();
        DataParser<FruitTransactionDto> fruitDataParser = new FruitDataParser();
        List<String> rawData = dataReaderService.read(inputPath);
        List<FruitTransactionDto> dtos = fruitDataParser.parse(rawData);

        TransactionProcessor transactionProcessor = new TransactionProcessorImpl(operationStrategy);
        transactionProcessor.process(dtos);

        Map<Fruit, Integer> storageData = storage.getFruits();
        ReportGeneratorImpl reportGenerator = new ReportGeneratorImpl();
        FileWriterImpl fileWriter = new FileWriterImpl();
        String reportContent = reportGenerator.generateReportContent(storageData);
        fileWriter.writeDataToFile(reportContent, reportPath);
    }
}
