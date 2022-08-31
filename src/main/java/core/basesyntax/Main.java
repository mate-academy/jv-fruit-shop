package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategy;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/Input.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/Output.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> mapOperationHandler = new HashMap<>();
        mapOperationHandler.put("b", new BalanceOperationHandler());
        mapOperationHandler.put("p", new PurchaseOperationHandler());
        mapOperationHandler.put("r", new ReturnOperationHandler());
        mapOperationHandler.put("s", new SupplyOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategy(mapOperationHandler);
        List<FruitTransaction> transactions = new ParserServiceImpl()
                .parse(new ReaderServiceImpl().readFromFile(INPUT_FILE_NAME));
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getByOperation(transaction.getOperation());
            handler.apply(transaction);
        }
        String report = new ReportServiceImpl().create(Storage.storage.entrySet());
        new WriteServiceImpl().writeToFile(OUTPUT_FILE_NAME, report);
    }
}


