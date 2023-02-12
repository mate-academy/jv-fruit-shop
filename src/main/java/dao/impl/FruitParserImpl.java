package dao.impl;

import dao.FruitParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import model.FruitTransaction;

public class FruitParserImpl implements FruitParser {
    private static final String LINE_SEPARATOR = ",";
    private static final int NAME_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(String[] activity) {
        if (activity == null) {
            throw new RuntimeException("Empty data!");
        }
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        String[] activityData;
        for (String data : activity) {
            activityData = data.split(LINE_SEPARATOR);
            FruitTransaction transaction = new FruitTransaction();
            transaction.setFruit(activityData[FRUIT_INDEX]);
            transaction.setQuantity(Integer.parseInt(activityData[QUANTITY_INDEX]));
            transaction.setOperation(getEnum(activityData[NAME_INDEX]));
            fruitTransactions.add(transaction);
        }
        return fruitTransactions;
    }

    public FruitTransaction.Operation getEnum(String fileOperation) {
        Optional<FruitTransaction.Operation> optionalOperation =
                Arrays.stream(FruitTransaction.Operation.values())
                        .filter(o -> o.getOperation().equals(fileOperation))
                        .findFirst();
        return optionalOperation.orElseThrow(() -> new NullPointerException("No such action"));
    }
}
