package core.basesyntax.service.parser;

import core.basesyntax.entity.FruitTransaction;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    public static final int ACTIVITY_POSITION = 0;
    public static final int FRUIT_POSITION = 1;
    public static final int QUANTITY_POSITION = 2;

    @Override
    public List<FruitTransaction> parser(List<String> str) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String d : str) {
            String[] split = d.split(",");
            if (d.trim().matches("\\w{1},[a-z]*,\\d*")) {
                FruitTransaction fruitTransaction = new FruitTransaction();
                String activity = split[ACTIVITY_POSITION];
                String fruit = split[FRUIT_POSITION];
                BigDecimal quantity = BigDecimal.valueOf(Long.parseLong(split[QUANTITY_POSITION]));
                fruitTransaction.setActivity(activity.trim());
                fruitTransaction.setFruit(fruit.trim());
                fruitTransaction.setQuantity(quantity);
                fruitTransactionList.add(fruitTransaction);
            }
        }
        return fruitTransactionList;
    }
}

