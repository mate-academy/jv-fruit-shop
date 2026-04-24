package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationHandlerProvider provider;

    public ShopServiceImpl(OperationHandlerProvider provider) {
        this.provider = provider;
    }

    @Override
    public Map<String, Integer> process(List<FruitTransaction> transactions) {
        Map<String, Integer> storage = new HashMap<>();

        for (FruitTransaction tx : transactions) {
            OperationHandler handler = provider.get(tx.getOperation());
            handler.apply(tx.getFruit(), tx.getQuantity(), storage);
        }
        return storage;
    }
}
