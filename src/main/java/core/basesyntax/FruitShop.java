package core.basesyntax;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {
    private Map<String, StoreOperations> operationsMap;
    private FileExecutor fileExecutor;
    private List<Fruit> fruits;

    public FruitShop() {
        fruits = new ArrayList<>();
        fileExecutor = new FileExecutor();
        operationsMap = new HashMap<>();
        operationsMap.put("s", new SupplyFruitsOperation());
        operationsMap.put("b", new BuyFruitsOperation());
        operationsMap.put("r", new ReturnFruitsOperation());
    }

    public FileExecutor getFileExecutor() {
        return fileExecutor;
    }

    public void executeRequestFile(String filePath) {
        for (String string : fileExecutor.readFile(filePath)) {
            String[] inputLine = string.replaceAll("[\\s\"]", "").split(",");
            String operationType = inputLine[0];
            String fruitName = inputLine[1];
            try {
                int quantity = Integer.parseInt(inputLine[2]);
                LocalDate date = LocalDate.parse(inputLine[inputLine.length - 1]);
                operationsMap.get(operationType).action(fruits,
                        fruitName, date, quantity);
            } catch (DateTimeParseException | NumberFormatException e) {
                throw new IllegalArgumentException("Incorrect parameters!");
            }
        }
    }

    public List<String> getFileWithStorageInfo(String filePath) {
        return fileExecutor.createFruitStoreFile(fruits, filePath);
    }
}
