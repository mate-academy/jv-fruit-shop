package core.basesyntax.operations;

import core.basesyntax.service.TransactionParser;

public class FruitAction implements Action {
    private static final String SUPPLY = "s";
    private static final String BUY = "b";
    private static final String RETURN = "r";

    @Override
    public boolean action(TransactionParser transaction) {
        String operation = transaction.getOperation();
        Integer quantity = transaction.getQuantity();
        String fruit = transaction.getFruit();
        String date = transaction.getDate();
        Operation supply = new SupplyOperation();
        Operation buy = new BuyOperation();
        Operation ret = new ReturnOperation();
        checkQuantity(quantity);
        switch (operation) {
            case SUPPLY:
                supply.provideOperation(fruit, quantity, date);
                return true;
            case BUY:
                buy.provideOperation(fruit, quantity, date);
                return true;
            case RETURN:
                ret.provideOperation(fruit, quantity, date);
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
