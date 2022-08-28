package core.basesyntax;

import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.AmountHandler;
import core.basesyntax.strategy.impl.BalanceAmount;
import core.basesyntax.strategy.impl.PurchaseAmount;
import core.basesyntax.strategy.impl.ReturnAmount;
import core.basesyntax.strategy.impl.SupplyAmount;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<String, AmountHandler> amountHandlerMap = new HashMap<>();
        amountHandlerMap.put("b", new BalanceAmount());
        amountHandlerMap.put("p", new PurchaseAmount());
        amountHandlerMap.put("r", new ReturnAmount());
        amountHandlerMap.put("s", new SupplyAmount());

        FruitService fruitService = new FruitServiceImpl(INPUT_FILE, OUTPUT_FILE, amountHandlerMap);
        fruitService.fruitService();
    }
}
