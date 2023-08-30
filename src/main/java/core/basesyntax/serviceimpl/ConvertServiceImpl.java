package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ConvertService;
import java.util.ArrayList;
import java.util.List;

public class ConvertServiceImpl implements ConvertService {
    private static final int typeIndex = 0;
    private static final int fruitIndex = 1;
    private static final int quantityIndex = 2;
    private static final List<FruitTransaction> transactionList = new ArrayList<>();

    @Override
    public List<FruitTransaction> convert(List<String> list) {
        for (String s : list) {
            String[] fruits = s.replaceAll("\\s+", "").split(",");
            String type = fruits[typeIndex];
            String fruit = fruits[fruitIndex];
            int quantity = Integer.parseInt(fruits[quantityIndex]);
            transactionList.add(new FruitTransaction(type, fruit, quantity));
            Storage.storage.put(fruit, 0);
        }
        return transactionList;
    }

}
