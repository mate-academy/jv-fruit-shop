package myFruitShop.ValidationProces;

import java.util.List;

public class ValidatorImpl implements Validator {

    public List<String> validator(List<String> uncheckedInfo) throws InvalidDataException {
        if (uncheckedInfo.isEmpty()) {
            throw new InvalidDataException("Invalid Data. Input file is empty");
        }
        for(String line: uncheckedInfo) {
            if (line == null || line.isEmpty()) {
                throw new InvalidDataException("Operation info is null, please change input");
            }
            if (line.split(",").length != 3) {
                throw new InvalidDataException("Invalid Data. Not enough information about operation and details");
            }

            if (line.split(",")[2] == null || line.split(",")[2].isEmpty() || line.split(",")[2].contains("-")) {
                throw new InvalidDataException("Invalid Data. Not Enough information about amount, or it`s invalid");
            }
        }
        return uncheckedInfo;
    }
}
