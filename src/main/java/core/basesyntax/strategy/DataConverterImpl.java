package core.basesyntax.strategy;

import core.basesyntax.model.Action;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATION_PLACE = ",";
    private static final int ACTION_PART = 0;
    private static final int FRUIT_PART = 1;
    private static final int QUANTITY_PART = 2;

    public List<FruitTransaction> convertToTransactions(List<String> dataList) {
        if (dataList == null) {
            throw new RuntimeException("Data list can not be null");
        }
        List<FruitTransaction> result = new ArrayList<>();
        for (String string : dataList) {
            String[] stringArray = string.split(SEPARATION_PLACE);
            Action action = Action.fromCode(stringArray[ACTION_PART]);
            String fruit = stringArray[FRUIT_PART];
            int quantity = Integer.parseInt(stringArray[QUANTITY_PART]);

            result.add(new FruitTransaction(action, fruit, quantity));
        }
        return result;
    }
}
