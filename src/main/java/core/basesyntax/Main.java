package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReadService;
import core.basesyntax.service.Transaction;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReadServiceImpl;
import core.basesyntax.service.impl.TransactionImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.AdditionalOperation;
import core.basesyntax.strategy.OperationHendler;
import core.basesyntax.strategy.SubtractionOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/java/core/basesyntax/files/input_file.csv";
    private static final String REPORT_FILE = "src/main/java/core/basesyntax/files/report_file.csv";

    public static void main(String[] args) {
        Transaction parser = new TransactionImpl();
        ReadService fileReader = new ReadServiceImpl();
        List<String> dataFromFile = fileReader.readFromFile(INPUT_FILE);
        final List<FruitTransaction> fruitTransactionList = parser.parseTransaction(dataFromFile);
        final WriteService writerService = new WriteServiceImpl();
        Map<FruitTransaction.Operation, OperationHendler> operationHandlerMap = new HashMap<>();
        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new AdditionalOperation());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new AdditionalOperation());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new SubtractionOperation());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new AdditionalOperation());
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            OperationHendler handler = strategy.get(fruitTransaction.getOperation());
            handler.operateTransaction(fruitTransaction);
        }
        writerService.wrightToFile(REPORT_FILE);
    }
}
