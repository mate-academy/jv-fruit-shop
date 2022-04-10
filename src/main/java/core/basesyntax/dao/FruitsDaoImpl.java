package core.basesyntax.dao;

import core.basesyntax.database.FruitDto;
import core.basesyntax.database.FruitsStorage;

public class FruitsDaoImpl implements FruitsDao {
    @Override
    public FruitDto get(String fruitName) {
        for (FruitDto fruitDto : FruitsStorage.fruitsStorage) {
            if (fruitDto.getName().equals(fruitName)) {
                return fruitDto;
            }
        }
        return null;
    }

    @Override
    public void put(FruitDto fruitDto) {
        FruitDto fruitDtoFromDB = get(fruitDto.getName());
        if (fruitDtoFromDB != null) {
            fruitDtoFromDB.setAmount(fruitDtoFromDB.getAmount() + fruitDto.getAmount());
        } else {
            FruitsStorage.fruitsStorage.add(fruitDto);
        }
    }
}
