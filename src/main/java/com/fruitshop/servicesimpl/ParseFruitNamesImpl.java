package com.fruitshop.servicesimpl;

import com.fruitshop.fruitsmodels.Fruit;
import com.fruitshop.services.Constants;
import com.fruitshop.services.ParseFruitNames;
import java.util.List;
import java.util.Map;

public class ParseFruitNamesImpl implements ParseFruitNames {

    private final DataBaseManagerImpl dataBaseManagerImpl = new DataBaseManagerImpl();

    public Map<String, Fruit> getFruitNamesMap(List<String> listOfAllFruits) {
        for (int i = 1; i < listOfAllFruits.size(); i++) {
            String[] indexArray = listOfAllFruits.get(i).split(Constants.COMMA);
            dataBaseManagerImpl.addToDB(indexArray[Constants.FRUIT_INDEX], new Fruit());
        }
        return dataBaseManagerImpl.getAllDB();
    }
}
