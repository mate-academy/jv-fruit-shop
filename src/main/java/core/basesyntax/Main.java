package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Reader;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderService;
import core.basesyntax.service.impl.WriterService;
import core.basesyntax.strategy.AmountHandler;
import core.basesyntax.strategy.AmountStrategy;
import core.basesyntax.strategy.impl.AmountStrategyImpl;
import core.basesyntax.strategy.impl.BalanceAmountHandler;
import core.basesyntax.strategy.impl.PurchaseAmountHandler;
import core.basesyntax.strategy.impl.ReturnAmountHandler;
import core.basesyntax.strategy.impl.SupplyAmountHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<String, AmountHandler> amountHandlerMap = new HashMap<>();
        amountHandlerMap.put("b", new BalanceAmountHandler());
        amountHandlerMap.put("p", new PurchaseAmountHandler());
        amountHandlerMap.put("r", new ReturnAmountHandler());
        amountHandlerMap.put("s", new SupplyAmountHandler());

        FruitDao fruitDao = new FruitDaoImpl();
        Reader reader = new ReaderService();
        Writer writer = new WriterService();
        AmountStrategy strategy = new AmountStrategyImpl(amountHandlerMap);
        FruitService fruitService = new FruitServiceImpl(strategy, fruitDao, reader, writer);
        fruitService.processData(INPUT_FILE, OUTPUT_FILE);
    }
}
