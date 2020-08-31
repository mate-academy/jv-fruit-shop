package core.parser;

import core.storage.Fruit;
import core.storage.Storage;
import java.time.LocalDate;
import java.util.List;

public class FruitDto {
    String defaultSeparator = ",";


    public Storage dtoParse(String path, String fullPath) {
        Storage storage = new Storage();
//        String path = "src/test/resources/";
        FileServiceImpl fileService = new FileServiceImpl();
        List<String> text = fileService.readFile(fullPath);
        for (String line : text) {
            String[] info = line.split(defaultSeparator);
            String fruitOperator = info[0];
            String fruitType = info[1];
            int quantity = Integer.parseInt(info[2]);
            LocalDate expDate = LocalDate.parse(info[3]);
            Fruit fruit = new Fruit(fruitType, expDate);
            try {
                storage.apply(fruit, quantity, fruitOperator);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return storage;
    }

    public boolean storageOut(Storage storage) {
        FileServiceImpl fileService = new FileServiceImpl();
        String path = "src/test/resources/fruitOut.csv";
        fileService.writeFile(storage.toList(), path);
        return true;
    }
}
