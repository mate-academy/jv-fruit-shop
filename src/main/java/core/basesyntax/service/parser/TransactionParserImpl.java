package core.basesyntax.service.parser;

import core.basesyntax.entity.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    public static final int ACTIVITY_POSITION = 0;
    public static final int FRUIT_POSITION = 1;
    public static final int QUANTITY_POSITION = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String d : lines) {
            String[] split = d.split(",");
            if (d.trim().matches("\\w{1},[a-z]*,\\d*")) {
                FruitTransaction fruitTransaction = new FruitTransaction();
                FruitTransaction.Operation operation =
                        getOperation(split[ACTIVITY_POSITION].trim());
                String fruit = split[FRUIT_POSITION];
                int quantity = Integer.parseInt(split[QUANTITY_POSITION]);
                fruitTransaction.setOperation(operation);
                fruitTransaction.setFruit(fruit.trim());
                fruitTransaction.setQuantity(quantity);
                fruitTransactionList.add(fruitTransaction);
            }
        }
        return fruitTransactionList;
    }

    private FruitTransaction.Operation getOperation(String code) {
        FruitTransaction.Operation[] values = FruitTransaction.Operation.values();
        FruitTransaction.Operation operation = null;
        for (int i = 0; i < values.length; i++) {
            if (values[i].getOperation().equalsIgnoreCase(code)) {
                operation = values[i];
                break;
            }
        }
        return operation;
    }
}
