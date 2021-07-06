package validator;

import dao.Columns;
import java.util.List;
import operation.OperationTypes;

public class FruitShopDataValidator implements Validator<List<String>> {
    private String[] partsOfLine;

    @Override
    public boolean validate(List<String> data) {
        for (String string : data) {
            partsOfLine = string.split(",");
            if (Columns.inColumns(partsOfLine[0])) {
                continue;
            }
            if (partsOfLine.length != 3
                    || !(OperationTypes.isOperationExist(partsOfLine[0]))
                    || !(new StringIsNumber().validate(partsOfLine[2])
                    || partsOfLine[2].charAt(0) == '-')) {
                return false;
            }
        }
        return true;
    }
}
