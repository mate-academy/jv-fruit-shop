package core.basesyntax.operations;

import core.basesyntax.service.Transaction;
import java.util.HashMap;
import java.util.Map;

public class FruitAction implements Action {
    private static final String SUPPLY = "s";
    private static final String BUY = "b";
    private static final String RETURN = "r";

    @Override
    public boolean action(Transaction transactionDto) {
        Map<String, Operation> operations = new HashMap<>();
        operations.put(SUPPLY, new SupplyOperation());
        operations.put(BUY, new BuyOperation());
        operations.put(RETURN, new ReturnOperation());
        String fruitOperation = transactionDto.getOperation();
        Integer quantity = transactionDto.getQuantity();
        String fruit = transactionDto.getFruit();
        String date = transactionDto.getDate();
        checkQuantity(quantity);
        if (!operations.containsKey(fruitOperation)) {
            throw new UnsupportedOperationException("Unsupported fruitOperation");
        }
        operations.get(fruitOperation).provideOperation(fruit, quantity, date);
        return true;
    }

    private void checkQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("The quantity cannot be zero or negative!");
        }
    }
}
