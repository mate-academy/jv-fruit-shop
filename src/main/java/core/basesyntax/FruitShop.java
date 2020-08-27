package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.services.*;
import core.basesyntax.services.impl.Parse;

import java.beans.IntrospectionException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class FruitShop {
    private final String path;
    private static final String STOCK_FILE = "src/main/resources/stock.csv";

    public FruitShop(String path) {
        this.path = path;
    }

    public void start() {
        Storage storage = new Storage();
        FruitParse fruitParse = new Parse();
        for (List<String> row : fruitParse.readFile(path)) {
            ActionInterface action = new ShopInterfaceStrategy().get(row.get(0));
            if (action != null) {
                Fruit fruit = new Fruit(row.get(1), checkBalance(row.get(2)), checkDate(row.get(3)));
                action.action(storage, fruit);
            }
        }
        stock(storage);
    }

    private void stock(Storage storage) {
        try {
            FileWriter nFile = new FileWriter(STOCK_FILE);
            Map<String, Integer> map = new HashMap<>();
            storage.getFruits()
                    .stream()
                    .filter(fruit -> fruit.getStock_balance() > 0)
                    .forEach(fruit -> {
                        if (map.containsKey(fruit.getType())) {
                            map.put(fruit.getType(), fruit.getStock_balance() + map.get(fruit.getType()));
                        } else {
                            map.put(fruit.getType(), fruit.getStock_balance());
                        }
                    });

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                nFile.write(entry.getKey()+"="+entry.getValue()+"\n");
            }
            nFile.close();

        } catch (IOException e) {
            throw new RuntimeException("Нет доступа к файлу для записи");
        }
    }

    private LocalDate checkDate(String string) {
        try {
            return LocalDate.parse(string);
        } catch (DateTimeException e) {
            throw new RuntimeException("Ошибка в дате " + string);
        }
    }

    private Integer checkBalance(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Ошибка указанного в файле количества " + string);
        }
    }
}
