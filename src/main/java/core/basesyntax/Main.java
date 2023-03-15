package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitShopReportService;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.OperationStrategyService;
import core.basesyntax.service.ProcessFruitTransactionService;
import core.basesyntax.service.implementation.CsvFileReaderServiceImpl;
import core.basesyntax.service.implementation.CsvFileWriterServiceImpl;
import core.basesyntax.service.implementation.FruitShopReportServiceImpl;
import core.basesyntax.service.implementation.FruitTransactionServiceImpl;
import core.basesyntax.service.implementation.OperationStrategyServiceImpl;
import core.basesyntax.service.implementation.ProcessFruitTransactionServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.implementation.BalanceOperationStrategy;
import core.basesyntax.strategy.implementation.PurchaseOperationStrategy;
import core.basesyntax.strategy.implementation.ReturnOperationStrategy;
import core.basesyntax.strategy.implementation.SupplyOperationStrategy;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/testInput.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/testOutput.csv";
    private static final Map<FruitTransaction.Operation, OperationStrategy> operationStrategyMap
            = Map.of(FruitTransaction.Operation.BALANCE, new BalanceOperationStrategy(),
            FruitTransaction.Operation.SUPPLY, new SupplyOperationStrategy(),
            FruitTransaction.Operation.PURCHASE, new PurchaseOperationStrategy(),
            FruitTransaction.Operation.RETURN, new ReturnOperationStrategy());

    public static void main(String[] args) {
        CsvFileReaderService readerService = new CsvFileReaderServiceImpl();
        List<String> inputLines = readerService.readFrom(INPUT_FILE_PATH);
        OperationStrategyService operationStrategyService =
                new OperationStrategyServiceImpl(operationStrategyMap);
        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl();
        ProcessFruitTransactionService processFruitTransactionService =
                new ProcessFruitTransactionServiceImpl(fruitTransactionService,
                        operationStrategyService);
        processFruitTransactionService.processFruitTransaction(inputLines);
        FruitShopReportService reportService = new FruitShopReportServiceImpl();
        String report = reportService.createReport();
        CsvFileWriterService writerService = new CsvFileWriterServiceImpl();
        writerService.write(report, OUTPUT_FILE_PATH);
    }
}
