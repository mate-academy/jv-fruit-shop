package com.fruitshop.servicesimpl;

import com.fruitshop.fruitsmodels.Fruit;
import com.fruitshop.services.FruitShopSupplier;
import com.fruitshop.strategy.HandlerConditionFactory;
import java.util.List;
import java.util.Map;

public class FruitShopSupplierImpl implements FruitShopSupplier {

    public static final String COMMA = ",";
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int AMOUNT_INDEX = 2;

    private final DataBaseManagerImpl dataBaseManagerImpl = new DataBaseManagerImpl();
    private final HandlerConditionFactory handler = new HandlerConditionFactory();

    public Map<String, Fruit> fillTheMap(List<String> listWithFruits) {
        for (int i = 1; i < listWithFruits.size(); i++) {
            String[] indexArray = listWithFruits.get(i).split(COMMA);
            handler.getHandler(indexArray[OPERATION_INDEX])
                    .orElseThrow(() -> new RuntimeException("Element " + indexArray[0]
                            + " is not in handler list"))
                    .putInDb(indexArray[FRUIT_INDEX],indexArray[AMOUNT_INDEX]);
        }
        return dataBaseManagerImpl.getAllDB();
    }
}
