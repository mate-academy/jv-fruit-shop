package core.basesyntax.validation;

import core.basesyntax.shop.FruitShop;

import java.util.Map;

public class CSVValidator implements Validator {
    private final Map<String, Integer> balance = new FruitShop().getBalance();
    private boolean isBalanceArea = true;

    @Override
    public boolean isValidRecord(String[] record) {
        if (record.length != 3) {
            throw new RuntimeException("Incorrect input file, record must contain "
                    + "`type`, `fruit` and `quantity`");
        }
        String type = record[0];
        String fruit = record[1];
        String quantity = record[2];
        return isValidType(type) && isValidFruit(fruit) && isValidQuantity(type, fruit, quantity);
    }

    private boolean isValidType(String stringType) {
        FruitShop.Operation type = FruitShop.Operation.getOperation(stringType);
        if (type != FruitShop.Operation.BALANCE) {
            isBalanceArea = false;
        }
        return type == FruitShop.Operation.BALANCE == isBalanceArea;
    }

    private boolean isValidFruit(String fruit) {
        if (fruit == null || fruit.isEmpty()
                || !fruit.replaceAll("[a-zA-Z]", "").isEmpty()) {
            throw new RuntimeException("It's not a fruit: " + fruit);
        }
        return true;
    }

    private boolean isValidQuantity(String stringType, String fruit, String quantity) {
        FruitShop.Operation type = FruitShop.Operation.getOperation(stringType);
        int amount = Integer.parseInt(quantity);
        if (amount < 0 || type == FruitShop.Operation.PURCHASE && balance.get(fruit) < amount) {
            throw new RuntimeException("Invalid quantity: " + quantity);
        }
        return true;
    }
}
