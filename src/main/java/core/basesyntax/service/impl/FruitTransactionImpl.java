package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Operations;
import core.basesyntax.service.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionImpl implements FruitTransaction {
    private static FruitShopDao fruitShopDao = new FruitShopDaoImpl();
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_NAME = 1;
    private static final int INDEX_QUANTITY = 2;
    private static final int START_FIND_ELEMENTS = 1;
    private static final int INITIALIZATION_QUANTITY_IN_DB = 0;
    private static final String SPLIT_CHARACTER = ",";

    @Override
    public void dateProcessing(List<String> data) {
        validateDB(data);
        for (int i = START_FIND_ELEMENTS; i < data.size(); i++) {
            String[] splitElements = data.get(i).split(SPLIT_CHARACTER);
            int pars = Integer.parseInt(splitElements[INDEX_QUANTITY]);
            if (Operations.BALANCE.getOperation().equals(splitElements[INDEX_OPERATION])) {
                fruitShopDao.add(splitElements[INDEX_NAME],
                        Storage.fruitStorage.get(splitElements[INDEX_NAME]));
            }
            if (Operations.PURCHASE.getOperation().equals(splitElements[INDEX_OPERATION])) {
                fruitShopDao.add(splitElements[INDEX_NAME],
                        Storage.fruitStorage.get(splitElements[INDEX_NAME]) - pars);
            }
            if (Operations.SUPPLY.getOperation().equals(splitElements[INDEX_OPERATION])) {
                fruitShopDao.add(splitElements[INDEX_NAME],
                        Storage.fruitStorage.get(splitElements[INDEX_NAME]) + pars);
            }
            if (Operations.RETURN.getOperation().equals(splitElements[INDEX_OPERATION])) {
                fruitShopDao.add(splitElements[INDEX_NAME],
                        Storage.fruitStorage.get(splitElements[INDEX_NAME]) + pars);
            }
        }
    }

    private static void validateDB(List<String> data) {
        if (Storage.fruitStorage.size() == 0) {
            initializationDB(data);
        } else {
            List<String> namesFruit = getNamesFruitFromList(data);
            for (int i = START_FIND_ELEMENTS; i < namesFruit.size(); i++) {
                if (!Storage.fruitStorage.containsKey(namesFruit.get(i))) {
                    fruitShopDao.add(namesFruit.get(i), INITIALIZATION_QUANTITY_IN_DB);
                }
            }
        }
    }

    private static List<String> getNamesFruitFromList(List<String> data) {
        List<String> assortment = new ArrayList<>();
        for (String output : data) {
            String[] splitData = output.split(SPLIT_CHARACTER);
            assortment.add(splitData[INDEX_NAME]);
        }
        return assortment;
    }

    private static void initializationDB(List<String> data) {
        for (int i = START_FIND_ELEMENTS; i < data.size(); i++) {
            String[] splitElements = data.get(i).split(SPLIT_CHARACTER);
            fruitShopDao.add(splitElements[INDEX_NAME], INITIALIZATION_QUANTITY_IN_DB);
        }
    }
}
