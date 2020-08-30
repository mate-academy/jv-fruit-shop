package core.basesyntax.operations;

public class FruitAction implements Action {
    private static final String SUPPLY = "s";
    private static final String BUY = "b";
    private static final String RETURN = "r";

    @Override
    public boolean action(String act, String fruit, int quantity, String date) {
        Operation supply = new SupplyOperation();
        Buy buy = new BuyOperation();
        Operation ret = new ReturnOperation();
        checkQuantity(quantity);
        switch (act) {
            case SUPPLY:
                supply.provideOperation(fruit, quantity);
                return true;
            case BUY:
                buy.buyFruit(fruit, quantity, date);
                return true;
            case RETURN:
                ret.provideOperation(fruit, quantity);
                return true;
            default:
                throw new UnsupportedOperationException("Wrong operation format.");
        }
    }

    private void checkQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("The quantity cannot be zero or negative!");
        }
    }
}
