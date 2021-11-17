package core.basesyntax.validator;

import java.util.List;

public class ValidatorImpl implements Validator {
    private static final int VALID_LENGTH_OF_DATA = 3;
    private static final String HEAD = "type,fruit,quantity";

    @Override
    public void validateData(List<String> data) {
        data.remove(HEAD);
        for (String line : data) {
            String[] lineArray = line.split(",");
            int quantity = Integer.parseInt(lineArray[2]);
            if (lineArray.length != VALID_LENGTH_OF_DATA
                    || quantity < 0
                    || lineArray[1].equals("")
                    || lineArray[1].isEmpty()) {
                throw new RuntimeException("Invalid data, try again");
            }
        }
    }
}
