package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.OperationHandler;
import service.impl.ParserImpl;
import service.impl.ReaderImpl;
import service.impl.WriterImpl;
import service.impl.operations.BalanceOperationHandler;
import service.impl.operations.PurchaseOperationHandler;
import service.impl.operations.ReturnOperationHandler;
import service.impl.operations.SupplyOperationHandler;
import strategy.OperationStrategyImpl;

public class Main {
    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationsWithHandlers = new HashMap<>();

        operationsWithHandlers.put(Operation.BALANCE, new BalanceOperationHandler());
        operationsWithHandlers.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationsWithHandlers.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationsWithHandlers.put(Operation.RETURN, new ReturnOperationHandler());

        ReaderImpl reader = new ReaderImpl();
        List<String> input = reader.readFromFile("src/main/resources/input.txt");
        ParserImpl parser = new ParserImpl();
        List<FruitTransaction> fruitTransactions = parser.parseInput(input);

        OperationStrategyImpl strategy = new OperationStrategyImpl(operationsWithHandlers);

        for (FruitTransaction transaction : fruitTransactions) {
            transaction.performTransaction(strategy);
        }

        WriterImpl writer = new WriterImpl();
        writer.writeToFile("src/main/resources/output.txt");
    }
}
