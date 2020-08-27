package services;

import exceptions.ExpiredProductException;
import exceptions.NotEnoughQuantityException;
import interfaces.StorageServiceInterface;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import model.Fruit;
import model.FruitStorage;

public class StorageService implements StorageServiceInterface {
    private static final String HEADER_FOR_REPORT = "PRODUCT, QUANTITY, SHELF LIFE \n";

    @Override
    public void put(Fruit fruit) {
        if (!isFresh(fruit)) {
            throw new ExpiredProductException("Sorry! Product expired");
        }
        if (FruitStorage.storage.containsKey(fruit.getName())) {
            int totalQuantity = FruitStorage.storage.get(
                    fruit.getName()).getQuantity() + fruit.getQuantity();
            fruit.setQuantity(totalQuantity);
            FruitStorage.storage.put(fruit.getName(), fruit);
        }
        FruitStorage.storage.put(fruit.getName(), fruit);
    }

    @Override
    public Map buy(String fruitName, int neededQuantity) {
        if (!isEnough(fruitName, neededQuantity)) {
            throw new NotEnoughQuantityException("Sorry! Not enough " + fruitName);
        }
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Fruit> entry : FruitStorage.storage.entrySet()) {
            if (entry.getKey().equals(fruitName)) {
                Fruit fruit = FruitStorage.storage.get(fruitName);
                fruit.setQuantity(fruit.getQuantity() - neededQuantity);
                FruitStorage.storage.put(fruitName, fruit);
            }
        }
        return result;
    }

    @Override
    public Map getReport() {
        StringBuilder content = new StringBuilder(HEADER_FOR_REPORT);
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Fruit> entry : FruitStorage.storage.entrySet()) {
            if (result.containsKey(entry.getKey())) {
                result.put(entry.getKey(),
                        result.get(entry.getKey()) + entry.getValue().getQuantity());
                appendInfo(entry, content);
                continue;
            }
            result.put(entry.getKey(), entry.getValue().getQuantity());
            appendInfo(entry, content);
        }
        FileService fileService = new FileService();
        fileService.writeFile(content.toString());
        return result;
    }

    @Override
    public boolean isEnough(String fruitName, int neededQuantity) {
        int availability = 0;
        for (Map.Entry<String, Fruit> entry : FruitStorage.storage.entrySet()) {
            if (entry.getKey().equals(fruitName)) {
                availability += entry.getValue().getQuantity();
            }
        }
        return availability >= neededQuantity;
    }

    public boolean isFresh(Fruit fruit) {
        LocalDate localDate = LocalDate.now();
        LocalDate shelfLife = LocalDate.parse(fruit.getDate());
        return shelfLife.isAfter(localDate);
    }

    private StringBuilder appendInfo(Map.Entry<String, Fruit> entry, StringBuilder content) {
        content.append(entry.getKey())
                .append(", ")
                .append(entry.getValue().getQuantity())
                .append(", ")
                .append(entry.getValue().getDate())
                .append("\n");
        return content;
    }
}
