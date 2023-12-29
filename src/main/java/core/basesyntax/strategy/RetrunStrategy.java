package core.basesyntax.strategy;

import core.basesyntax.functional.Function;
import core.basesyntax.functional.FunctionImpl;
import java.util.Map;

public class RetrunStrategy implements Strategy {
    private final Function function = new FunctionImpl();

    @Override
    public int countBalance(String fruit, String quantity, Map<String, String> map) {
        int balance = Integer.parseInt(map.get(fruit));
        int fruitQuantity = Integer.parseInt(quantity);
        int result = balance + fruitQuantity;
        function.checkPositiveValueOfBalance(result);
        return result;
    }
}
