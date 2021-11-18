package core.basesyntax.validator;

import java.util.List;

public class ValidatorImpl implements Validator {
    private static final int VALID_LENGTH_OF_LINE = 3;
    private static final String HEAD = "type,fruit,quantity";

    @Override
    public void validateData(List<String> data) {
        if (!checkFirstLine(data)) {
            throw new RuntimeException("Invalid input data, try again");
        }

        data.remove(HEAD);
        for (String line : data) {
            String[] lineArray = line.split(",");
            if (lineArray.length != VALID_LENGTH_OF_LINE
                    || Integer.parseInt(lineArray[2]) < 0
                    || lineArray[1].equals("")
                    || lineArray[1].isEmpty()) {
                throw new RuntimeException("Invalid data, try again");
            }
        }
    }

    private boolean checkFirstLine(List<String> data) {
        return data.get(0).equals(HEAD);
    }

}
