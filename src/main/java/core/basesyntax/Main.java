package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.servise.FileReaderService;
import core.basesyntax.servise.FileWriterService;
import core.basesyntax.servise.FruitTransactionProcessorService;
import core.basesyntax.servise.LineParserService;
import core.basesyntax.servise.impl.FileReaderServiceImpl;
import core.basesyntax.servise.impl.FileWriterServiceImpl;
import core.basesyntax.servise.impl.FruitTransactionProcessorServiceImpl;
import core.basesyntax.servise.impl.LineParserServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperation;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperation;
import core.basesyntax.strategy.operation.ReturnOperation;
import core.basesyntax.strategy.operation.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final java.lang.String INITIAL_FILE_PATH = "src/main/resources/data.csv";
    private static final java.lang.String RESULT_FILE_PATH = "src/main/resources/result.csv";

    public static void main(java.lang.String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        handlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        handlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        handlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        FileReaderService reader = new FileReaderServiceImpl();
        List<String> lines = reader.read(INITIAL_FILE_PATH);
        LineParserService lineParserService = new LineParserServiceImpl();
        List<FruitTransaction> fruitTransactions = lineParserService.parse(lines);
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlerMap);
        FruitTransactionProcessorService data
                = new FruitTransactionProcessorServiceImpl(operationStrategy);
        String report = data.process(fruitTransactions);
        FileWriterService writer = new FileWriterServiceImpl();
        writer.write(RESULT_FILE_PATH, report);
    }
}
