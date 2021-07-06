package validator;

import dao.Columns;
import java.util.List;
import strategy.OperationTypes;

public class FruitShopDataValidator implements Validator<List<String>> {
    private static final Integer TYPE_INDEX = 0;
    private static final Integer FRUIT_INDEX = 1;
    private static final Integer QUANTITY_INDEX = 2;
    private static final String SPLITERATOR = ",";
    private static final Integer CSV_DATA_PARTS = 3;

    @Override
    public boolean validate(List<String> data) {
        String[] partsOfLine;
        for (String string : data) {
            partsOfLine = string.split(SPLITERATOR);
            if (Columns.inColumns(partsOfLine[TYPE_INDEX])) {
                continue;
            }
            if (partsOfLine.length != CSV_DATA_PARTS
                    || !(OperationTypes.isOperationExist(partsOfLine[TYPE_INDEX]))
                    || !(new StringIsNumber().validate(partsOfLine[QUANTITY_INDEX])
                    || partsOfLine[QUANTITY_INDEX].charAt(0) == '-')) {
                return false;
            }
        }
        return true;
    }
}
