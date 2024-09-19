package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Action;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    public List<FruitTransaction> convertToTransactions(List<String> dateList) {
        List<FruitTransaction> result = new ArrayList<>();
        for (String string : dateList) {
            String[] stringArray = string.split(",");
            Action action = Action.fromCode(stringArray[0]);
            String fruit = stringArray[1];
            int quantity = Integer.parseInt(stringArray[2]);

            result.add(new FruitTransaction(action, fruit, quantity));
        }
        return result;
    }
}
