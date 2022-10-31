package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitActionParser;
import core.basesyntax.dao.exception.NoSuchEnumValue;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FruitActionParserImpl implements FruitActionParser {
    private static final String WORDS_SPLITERATOR = ",";
    private static final int ACTIVITY_TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseAction(String[] activity) {
        if (activity == null) {
            throw new RuntimeException("Empty data!");
        }
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        String[] activityData;
        for (String data : activity) {
            activityData = data.split(WORDS_SPLITERATOR);
            FruitTransaction transaction = new FruitTransaction();
            transaction.setFruit(activityData[FRUIT_INDEX]);
            transaction.setQuantity(Integer.parseInt(activityData[QUANTITY_INDEX]));
            transaction.setOperation(getEnumValue(activityData[ACTIVITY_TYPE_INDEX]));
            fruitTransactions.add(transaction);
        }
        return fruitTransactions;
    }

    public FruitTransaction.Operation getEnumValue(String fileOperation) {
        Optional<FruitTransaction.Operation> optionalOperation =
                Arrays.stream(FruitTransaction.Operation.values())
                        .filter(o -> o.getOperation().equals(fileOperation))
                        .findFirst();
        return optionalOperation.orElseThrow(() -> new NoSuchEnumValue("No such action"));
    }
}
