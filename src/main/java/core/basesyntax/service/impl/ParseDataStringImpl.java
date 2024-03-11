package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseDataString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseDataStringImpl implements ParseDataString {
    private static final int CODE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> parse(String data) {
        List<FruitTransaction> fruitList = new ArrayList<>();
        String[] splitData = data.split(System.lineSeparator());
        for (String line : splitData) {
            String[] dataFruit = line.split(",");
            if (dataFruit.length != 3) {
                throw new RuntimeException("Data aren`t correct: " + Arrays.toString(dataFruit));
            }
            fruitList.add(new FruitTransaction(
                    dataFruit[CODE].equals(FruitTransaction.Operation.SUPPLY.getCode())
                    ? FruitTransaction.Operation.SUPPLY
                    : dataFruit[CODE].equals(FruitTransaction.Operation.RETURN.getCode())
                    ? FruitTransaction.Operation.RETURN
                    : dataFruit[CODE].equals(FruitTransaction.Operation.PURCHASE.getCode())
                    ? FruitTransaction.Operation.PURCHASE
                            : FruitTransaction.Operation.BALANCE,
                    dataFruit[FRUIT],
                    Integer.parseInt(dataFruit[QUANTITY])));
        }
        return fruitList;
    }
}
