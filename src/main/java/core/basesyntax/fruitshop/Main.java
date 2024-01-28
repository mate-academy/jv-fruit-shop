package core.basesyntax.fruitshop;

import core.basesyntax.fruitshop.impl.BalanceHandler;
import core.basesyntax.fruitshop.impl.FruitShopServiceImpl;
import core.basesyntax.fruitshop.impl.ParserServiceImpl;
import core.basesyntax.fruitshop.impl.PurchaseHandler;
import core.basesyntax.fruitshop.impl.ReaderServiceImpl;
import core.basesyntax.fruitshop.impl.ReturnHandler;
import core.basesyntax.fruitshop.impl.SupplyHandler;
import core.basesyntax.fruitshop.impl.WriterServiceImpl;
import core.basesyntax.fruitshop.model.FruitTransaction;
import core.basesyntax.fruitshop.service.ParserService;
import core.basesyntax.fruitshop.service.ReaderService;
import core.basesyntax.fruitshop.service.WriterService;
import core.basesyntax.fruitshop.strategy.OperationHandler;
import core.basesyntax.fruitshop.strategy.OperationStrategy;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    public static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        ParserService parserService = new ParserServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        OperationStrategy operationStrategy = initializeOperationStrategy();

        FruitShopServiceImpl fruitShopService =
                new FruitShopServiceImpl(parserService, operationStrategy);

        try {
            List<String> lines = readerService.readLines(INPUT_FILE_PATH);
            List<FruitTransaction> transactions = fruitShopService.parseTransactions(lines);
            Map<String, Integer> fruitInventory
                    = fruitShopService.processTransactions(transactions);
            writerService.writeReport(fruitInventory, OUTPUT_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static OperationStrategy initializeOperationStrategy() {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        return operationHandlers::get;
    }
}
