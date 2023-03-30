import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ParserService;
import service.ReaderService;
import service.WriterService;
import service.impl.ParserServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.BalanceOperationHandler;
import strategy.FruitStrategy;
import strategy.FruitStrategyImpl;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;
import strategy.ReturnOperationHandler;
import strategy.SupplyOperationHandler;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        FruitStrategy fruitStrategy = new FruitStrategyImpl(operationHandlerMap);
        ParserService parser = new ParserServiceImpl();
        ReaderService reader = new ReaderServiceImpl();

        List<String> stringsFromInputData = reader.get();

        List<FruitTransaction> fruitTransactions = parser.parseTransaction(stringsFromInputData);

        for (FruitTransaction transaction : fruitTransactions) {
            fruitStrategy.get(transaction.getOperation()).operate(transaction);
        }

        WriterService writer = new WriterServiceImpl();
        writer.getReport();
    }
}
