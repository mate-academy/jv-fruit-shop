package core.basesyntax;

import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final FruitStock fruitStock;
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(FruitStock fruitStock, OperationStrategy operationStrategy) {
        this.fruitStock = fruitStock;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void addFruit(String fruit, int quantity) {
        fruitStock.add(fruit, quantity);
    }

    @Override
    public int getFruitQuantity(String fruit) {
        return fruitStock.getQuantity(fruit);
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            if (handler != null) {
                handler.handle(transaction.getFruit(), transaction.getQuantity());
            } else {
                System.out.println("No handler found for operation: " + transaction.getOperation());
            }
        }
    }
}
