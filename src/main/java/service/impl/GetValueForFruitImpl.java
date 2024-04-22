package service.impl;

import dao.FruitDao;
import dao.FruitDaoImpl;
import service.GetValueForFruit;

public class GetValueForFruitImpl implements GetValueForFruit {
    private static final String SPECIAL_CHARACTER = ",";
    private static final int TYPE_FRUIT_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int VALUE_INDEX = 2;

    FruitDao fruitDao = new FruitDaoImpl();
    @Override
    public Integer calculateNewValue(String line) {
        String[] arr = line.split(SPECIAL_CHARACTER);
        GetOperationTypeImpl getOperationTypeImpl = new GetOperationTypeImpl();
        GetFruitFromFileImpl getFruitFromFileImpl = new GetFruitFromFileImpl();

        switch (getOperationTypeImpl.checkOperationType(arr[TYPE_FRUIT_INDEX])) {
            case BALANCE:
                return Integer.parseInt(arr[VALUE_INDEX]);
            case PURCHASE:
                int value = fruitDao.get(getFruitFromFileImpl.getFruit(arr[FRUIT_INDEX]))
                        - Integer.parseInt(arr[VALUE_INDEX]);
                if (value >= 0) {
                    return value;
                } else {
                    throw new IllegalArgumentException("Insufficient balance for purchase");
                }
            case SUPPLY:
            case RETURN:
                return Integer.parseInt(arr[VALUE_INDEX])
                        + fruitDao.get(getFruitFromFileImpl.getFruit(arr[FRUIT_INDEX]));
            default:
                throw new RuntimeException(line + "don't have value");
        }
    }
}
