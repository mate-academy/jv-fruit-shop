import java.util.Map;

public class BalanceOperation implements OperationHandler {
    private final Map<String, Integer> fruitStorage;

    public BalanceOperation(Map<String, Integer> fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        fruitStorage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
