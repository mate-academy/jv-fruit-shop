package core.basesyntax.dao;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class ProductDaoServiceImpl implements ProductDaoService {
    private static final String DEFAULT_INFORMATION = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public void update(FruitTransaction fruitTransaction, int count) {
        FruitsStorage.FRUIT_MAP.put(fruitTransaction.getFruit(), count);
    }

    @Override
    public int getQuantityOf(FruitTransaction fruitTransaction) {
        Integer quantity = FruitsStorage.FRUIT_MAP.get(fruitTransaction.getFruit());
        if (quantity == null) {
            return 0;
        }
        return quantity;
    }

    @Override
    public String getAllData() {
        StringBuilder stringBuilder = new StringBuilder(DEFAULT_INFORMATION
                + System.lineSeparator());
        for (Map.Entry<String, Integer> item : FruitsStorage.FRUIT_MAP.entrySet()) {
            stringBuilder.append(item.getKey())
                    .append(SEPARATOR)
                    .append(item.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

}
