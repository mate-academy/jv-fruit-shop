package com.fruitshop.servicesimpl;

import com.fruitshop.dao.DataBaseManagerImpl;
import com.fruitshop.model.Fruit;
import com.fruitshop.services.ParseFruitNames;
import java.util.List;
import java.util.Map;

public class ParseFruitNamesImpl implements ParseFruitNames {
    public static final String COMMA = ",";
    public static final int FRUIT_INDEX = 1;
    public static final int HEADER_INDEX = 0;
    private final DataBaseManagerImpl dataBaseManagerImpl = new DataBaseManagerImpl();

    public Map<String, Fruit> getFruitNamesMap(List<String> listOfAllFruits) {
        for (int i = 0; i < listOfAllFruits.size(); i++) {
            if (i == HEADER_INDEX) {
                continue;
            }
            String[] indexArray = listOfAllFruits.get(i).split(COMMA);
            dataBaseManagerImpl.addToDB(indexArray[FRUIT_INDEX], new Fruit());
        }
        return dataBaseManagerImpl.getAllDB();
    }
}
