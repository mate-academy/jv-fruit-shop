package core.basesyntax.service.files;

import java.util.List;

public class ValidatorImpl implements Validator {
    private static final String FIRST_LINE = "type,fruit,quantity";
    private static final int FIRST_LINE_FROM_INPUT = 0;
    private static final int OPERATION = 0;
    private static final int AMOUNT = 2;
    private static final int VALID_LENGTH = 3;
    private static final String REGEX_FOR_SPLIT = ",";

    @Override
    public void isValid(List<String> infoFromInputFile) {
        if (!infoFromInputFile
                .get(FIRST_LINE_FROM_INPUT)
                .equals(FIRST_LINE)) {
            throw new RuntimeException("Invalid input file!");
        }
        infoFromInputFile.remove(FIRST_LINE_FROM_INPUT);
        for (String line : infoFromInputFile) {
            String[] splitedLine = line.split(REGEX_FOR_SPLIT);
            if (!(splitedLine.length == VALID_LENGTH
                    && (splitedLine[OPERATION].equals("b")
                    || splitedLine[OPERATION].equals("p")
                    || splitedLine[OPERATION].equals("r")
                    || splitedLine[OPERATION].equals("s"))
                    || Integer.parseInt(splitedLine[AMOUNT]) < 0)) {
                throw new RuntimeException("Invalid given values!");
            }
        }
    }
}
