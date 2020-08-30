package core.basesyntax.storage;

import core.basesyntax.products.Fruit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListShopStorage {
    public static List<Fruit> listStorage = new ArrayList<>();

    public List<String> sortDataBeforeWrite() {
        Map<String, Integer> mapToFile = ListShopStorage.listStorage.stream()
                .collect(Collectors.groupingBy(Fruit::getName,
                        Collectors.summingInt(Fruit::getAmount)));
        List<String> stringsToFile = new ArrayList<>();
        stringsToFile.add("fruit,quantity");
        for (Map.Entry<String, Integer> entry : mapToFile.entrySet()) {
            stringsToFile.add(entry.getKey() + "," + entry.getValue());
        }
        return stringsToFile;
    }
}
