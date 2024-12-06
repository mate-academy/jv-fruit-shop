package dao.impl;

import dao.WareHouseDao;
import db.WareHouse;
import java.util.Arrays;

public class WareHouseDaoImpl implements WareHouseDao {
    private static final int FRUIT_NAME_INDEX = 0;
    private static final int FRUIT_QUANTITY_INDEX = 1;

    @Override
    public int getStoredQuantity(String fruitName) {
        if (isFruitPresence(fruitName)) {
            String[] fruitLot = WareHouse.STORED_FRUITS
                    .stream()
                    .filter(array -> array[FRUIT_NAME_INDEX].equals(fruitName))
                    .findFirst().get();
            return Integer.parseInt(fruitLot[1]);
        }
        return 0;
    }

    @Override
    public void addFruitLot(String fruitName, Integer quantity) {
        if (isFruitPresence(fruitName)) {
            for (String[] fruitLot : WareHouse.STORED_FRUITS) {
                if (fruitLot[FRUIT_NAME_INDEX].equals(fruitName)) {
                    fruitLot[FRUIT_QUANTITY_INDEX]
                            = String.valueOf(Integer.parseInt(fruitLot[FRUIT_QUANTITY_INDEX])
                            + quantity);
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
        int lotIndex = FRUIT_NAME_INDEX;
        for (String[] fruitLot : WareHouse.STORED_FRUITS) {
            if (fruitLot[FRUIT_NAME_INDEX].equals(fruitName)) {
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
