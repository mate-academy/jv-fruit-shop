package services;

import exceptions.ExpiredProductException;
import exceptions.NotEnoughQuantityException;
import interfaces.IStorageService;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import model.Position;
import model.Storage;

public class StorageService implements IStorageService {

    @Override
    public void put(Position position) {
        if (!isFresh(position)) {
            throw new ExpiredProductException("Sorry! Product expired");
        }
        if (Storage.storage.containsKey(position.getName())) {
            int totalQuantity = Storage.storage.get(
                    position.getName()).getQuantity() + position.getQuantity();
            position.setQuantity(totalQuantity);
            Storage.storage.put(position.getName(), position);
        }
        Storage.storage.put(position.getName(), position);
    }

    @Override
    public Map buy(String fruitName, int neededQuantity) {
        if (!isEnough(fruitName, neededQuantity)) {
            throw new NotEnoughQuantityException("Sorry! Not enough " + fruitName);
        }
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Position> entry : Storage.storage.entrySet()) {
            if (entry.getKey().equals(fruitName)) {
                Position position = Storage.storage.get(fruitName);
                position.setQuantity(position.getQuantity() - neededQuantity);
                Storage.storage.put(fruitName, position);
            }
        }
        return result;
    }

    public boolean isEnough(String fruitName, int neededQuantity) {
        int availability = 0;
        for (Map.Entry<String, Position> entry : Storage.storage.entrySet()) {
            if (entry.getKey().equals(fruitName)) {
                availability += entry.getValue().getQuantity();
            }
        }
        return availability >= neededQuantity;
    }

    public boolean isFresh(Position position) {
        LocalDate localDate = LocalDate.now();
        LocalDate shelfLife = position.getDate();
        return shelfLife.isAfter(localDate);
    }
}
