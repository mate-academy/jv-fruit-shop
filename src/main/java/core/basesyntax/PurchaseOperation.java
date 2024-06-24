import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    private final Map<String, Integer> fruitStorage;

    public PurchaseOperation(Map<String, Integer> fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        fruitStorage.put(transaction.getFruit(), 
            fruitStorage.getOrDefault(transaction.getFruit(), 0) - transaction.getQuantity());
    }
}
