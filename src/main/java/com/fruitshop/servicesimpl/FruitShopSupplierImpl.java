package com.fruitshop.servicesimpl;

import com.fruitshop.fruitsmodels.Fruit;
import com.fruitshop.services.Constants;
import com.fruitshop.services.FruitShopSupplier;
import java.util.List;
import java.util.Map;

public class FruitShopSupplierImpl implements FruitShopSupplier {

    private final DataBaseManagerImpl dataBaseManagerImpl = new DataBaseManagerImpl();
    private final HandlerConditionFactory handler = new HandlerConditionFactory();

    public Map<String, Fruit> fillTheMap(List<String> listWithFruits) {
        for (int i = 1; i < listWithFruits.size(); i++) {
            String[] indexArray = listWithFruits.get(i).split(Constants.COMMA);
            handler.getHandler(indexArray[Constants.OPERATION_INDEX])
                    .orElseThrow(() -> new RuntimeException("Element " + indexArray[0]
                            + " is not in handler list"))
                    .putInDb(indexArray[Constants.FRUIT_INDEX],indexArray[Constants.AMOUNT_INDEX]);
        }
        return dataBaseManagerImpl.getAllDB();
    }
}
