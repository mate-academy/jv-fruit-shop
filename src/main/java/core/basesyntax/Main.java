package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.ProductParserImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE
            = "src/main/java/core/basesyntax/resources/inputFile.csv";
    private static final String OUTPUT_FILE
            = "src/main/java/core/basesyntax/resources/reportFile.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        OperationHandler operationHandlerBalance = new BalanceHandler(fruitDao);
        OperationHandler operationHandlerPurchase = new PurchaseHandler(fruitDao);
        OperationHandler operationHandlerReturn = new ReturnHandler(fruitDao);
        OperationHandler operationHandlerSupply = new SupplyHandler(fruitDao);

        Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE, operationHandlerBalance);
        handlerMap.put(FruitTransaction.Operation.PURCHASE, operationHandlerPurchase);
        handlerMap.put(FruitTransaction.Operation.RETURN, operationHandlerReturn);
        handlerMap.put(FruitTransaction.Operation.SUPPLY, operationHandlerSupply);

        OperationStrategy operationStrategy = new OperationStrategyImpl(handlerMap);

        List<String> records = new ReaderServiceImpl().readFromFile((INPUT_FILE));

        new ProductParserImpl().parseAll(records)
                .forEach(e -> operationStrategy.get(e.getOperation())
                        .handle(e));

        records = new ReportServiceImpl(fruitDao).createReport();
        new WriterServiceImpl().writeToFile(records, OUTPUT_FILE);
    }
}
