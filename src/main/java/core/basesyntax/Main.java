package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParsedStringInFile;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.impl.ParsedStringInFileImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, OperationHandler> mapOperationHandler = new HashMap<>();
        mapOperationHandler.put("b", new BalanceOperationHandler());
        mapOperationHandler.put("p", new PurchaseOperationHandler());
        mapOperationHandler.put("r", new ReturnOperationHandler());
        mapOperationHandler.put("s", new SupplyOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategy(mapOperationHandler);
        List<FruitTransaction> transactions = new ParsedStringInFileImpl()
                .parse(new ReaderServiceImpl().readFromFile("Input.csv"));
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getByOperation(transaction.getOperation());
            handler.apply(transaction);
        }
    }
}


