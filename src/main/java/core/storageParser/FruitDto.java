package core.storageParser;

import core.storage.Fruit;
import core.storage.Storage;
import java.time.LocalDate;
import java.util.List;

public class FruitDto {
    String defaultSeparator = ",";
    Storage storage = new Storage();

    public boolean dtoParse() {
        String path = "src/test/resources/";
        String fileName = "Fruit In";
        FileServiceImpl fileService = new FileServiceImpl();
        fileService.setPath(path);
        fileService.setFileName(fileName);
        List<String> text = fileService.readFile();
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
        fileName = "Fruit Out";
        fileService.writeFile(storage.toList(), fileName);
        return true;
    }
}
