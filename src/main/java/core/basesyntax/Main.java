package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.WriterService;
import service.impl.ParserServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.OperationStrategy;
import strategy.TransactionHandler;
import strategy.impl.BalanceImpl;
import strategy.impl.OperationStrategyImpl;
import strategy.impl.PurchaseImpl;
import strategy.impl.ReturnImpl;
import strategy.impl.SupplyImpl;

public class Main {
    private static final String FROM_FILE_NAME = "src/main/resources/file.txt";
    private static final String TO_FILE_NAME = "src/main/resources/report.txt";

    public static void main(String[] args) {
        List<String> data = new ReaderServiceImpl().readFromFile(FROM_FILE_NAME);
        Map<FruitTransaction.Operation, TransactionHandler> transactionHandlerMap = new HashMap<>();
        transactionHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceImpl());
        transactionHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseImpl());
        transactionHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnImpl());
        transactionHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyImpl());
        OperationStrategy operationStrategy = new OperationStrategyImpl(transactionHandlerMap);
        List<FruitTransaction> fruitTransactions = new ParserServiceImpl().parseFile(data);
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            TransactionHandler transactionHandler = operationStrategy
                    .get(fruitTransaction.getOperation());
            transactionHandler.getTransaction(fruitTransaction);
        }
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(TO_FILE_NAME);
    }
}
