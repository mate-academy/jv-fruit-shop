package com.companyname.fruitshop.model.dao;

import com.companyname.fruitshop.model.Fruit;
import com.companyname.fruitshop.model.dto.FruitRecordDto;
import com.companyname.fruitshop.storage.FruitStorage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(FruitRecordDto fruitRecord) {
        FruitStorage.getFruits().put(new Fruit(fruitRecord.getName()), fruitRecord.getQuantity());
    }

    @Override
    public void updateQuantity(FruitRecordDto fruitRecord, int quantity) {
        FruitStorage.getFruits().put(new Fruit(fruitRecord.getName()), quantity);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return FruitStorage.getFruits();
    }

    @Override
    public int getCurrentQuantity(FruitRecordDto fruitRecord) {
        return FruitStorage.getFruits().get(new Fruit((fruitRecord.getName())));
    }
}
