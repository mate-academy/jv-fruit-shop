package dao.impl;

import dao.WareHouseDao;
import db.WareHouse;
import java.util.Arrays;

public class WareHouseDaoImpl implements WareHouseDao {
    private static final int ZERO = 0;

    @Override
    public int getStoredQuantity(String fruitName) {
        if (isFruitPresence(fruitName)) {
            String[] fruitLot = WareHouse.STORED_FRUITS
                    .stream()
                    .filter(array -> array[0].equals(fruitName))
                    .findFirst().get();
            return Integer.parseInt(fruitLot[1]);
        }
        return ZERO;
    }

    @Override
    public void addFruitLot(String fruitName, Integer quantity) {
        if (isFruitPresence(fruitName)) {
            for (String[] fruitLot : WareHouse.STORED_FRUITS) {
                if (fruitLot[0].equals(fruitName)) {
                    fruitLot[1] = String.valueOf(Integer.parseInt(fruitLot[1]) + quantity);
                    break;
                }
            }
        } else {
            String[] newFruitLot = {fruitName, String.valueOf(quantity)};
            WareHouse.STORED_FRUITS.add(newFruitLot);
        }
    }

    @Override
    public void removeFruitLot(String fruitName) {
        int lotIndex = ZERO;
        for (String[] fruitLot : WareHouse.STORED_FRUITS) {
            if (fruitLot[0].equals(fruitName)) {
                WareHouse.STORED_FRUITS.remove(lotIndex);
                break;
            }
            lotIndex++;
        }
    }

    private boolean isFruitPresence(String fruitName) {
        return WareHouse.STORED_FRUITS
                .stream()
                .flatMap(Arrays::stream)
                .anyMatch(s -> s.equals(fruitName));
    }
}
