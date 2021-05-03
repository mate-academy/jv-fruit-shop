package datavalidation;

import fruitsassortment.ListOfFruits;
import shopoperations.ListOfOperations;

public class DataValidator implements DataValidation {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int PRODUCT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public boolean validateData(String data) {
        if ("type,fruit,quantity".equals(data)) {
            return true;
        }
        String dataType = data.split(SEPARATOR)[OPERATION_TYPE_INDEX].toUpperCase();
        if (!ListOfOperations.contains(dataType)) {
            throw new RuntimeException("Such operation is not valid "
                    + dataType);
        }
        dataType = data.split(SEPARATOR)[PRODUCT_NAME_INDEX];
        if (!ListOfFruits.contains(dataType.toUpperCase())) {
            throw new RuntimeException("Such fruit does not exist "
                    + dataType);
        }
        dataType = data.split(SEPARATOR)[AMOUNT_INDEX];
        if (Integer.parseInt(dataType) < 0) {
            throw new RuntimeException("Amount can't be less than zero.");
        }
        return true;
    }
}
