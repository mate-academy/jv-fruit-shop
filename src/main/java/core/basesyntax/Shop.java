package core.basesyntax;

import core.basesyntax.service.ReadFromFileImpl;
import core.basesyntax.service.SetDataIntoMapImpl;
import core.basesyntax.service.WriteToFileImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {

    private Map<String, Integer> shop = new HashMap<>();

    public Shop(String pathData, String pathResult) {
        shop.put("banana", 0);
        shop.put("apple", 0);

        List<String> dataFromFile = new ReadFromFileImpl().readFromFile(pathData);
        new SetDataIntoMapImpl().setDataIntoMap(shop, dataFromFile);

        new WriteToFileImpl().write(pathResult, shop);
    }
}
