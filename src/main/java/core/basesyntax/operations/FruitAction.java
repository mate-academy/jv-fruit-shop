package core.basesyntax.operations;

import java.util.List;

public class FruitAction implements Action {
    private static final String SUPPLY = "s";
    private static final String BUY = "b";
    private static final String RETURN = "r";
    public boolean result = false;

    @Override
    public boolean action(List<List<String>> rows) {
        Supply supply = new SupplyOperation();
        Buy buy = new BuyOperation();
        Return ret = new ReturnOperation();
        for (List<String> row : rows) {
            if (!row.isEmpty()) {
                System.out.println(row);
                String act = row.get(0);
                String fruit = row.get(1);
                String date = row.get(3);
                int quantity = Integer.parseInt(row.get(2));
                checkQuantity(quantity);
                switch (act) {
                    case SUPPLY:
                        supply.supplyFruit(fruit, quantity);
                        result = true;
                        continue;
                    case BUY:
                        buy.buyFruit(fruit, quantity, date);
                        result = true;
                        continue;
                    case RETURN:
                        ret.returnFruit(fruit, quantity);
                        result = true;
                        continue;
                    default:
                        throw new UnsupportedOperationException("Unsupported Operation.");
                }
            }
        }
        return false;
    }

    private void checkQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("The quantity cannot be zero or negative!");
        }
    }
}
