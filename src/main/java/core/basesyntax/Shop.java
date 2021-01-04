package core.basesyntax;

import core.basesyntax.service.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {

    private Map<String, Integer> shop = new HashMap<>();

    public Shop(String fileNameData, String fileNameResult) {
        shop.put("banana", 0);
        shop.put("apple", 0);

        List<String> dataFromFile = new ReadFromFileImpl().readFromFile(fileNameData);
        new SetDataIntoMapImpl().setDataIntoMap(shop, dataFromFile);

        new WriteToFileImpl().write(fileNameResult, shop);
    }
}
