package validator;

import java.util.Arrays;

public class ValidatorImp implements Validator {
    private static final int ARRAY_LINE_LENGTH = 3;
    private static final String[] ACTIVITIES_CODES = new String[] {"p", "b", "r", "s"};

    @Override
    public boolean validationReportLine(String[] line) {
        if (line == null) {
            return false;
        }
        if (line.length != ARRAY_LINE_LENGTH) {
            return false;
        }
        try {
            if (Integer.parseInt(line[2]) < 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return Arrays.asList(ACTIVITIES_CODES).contains(line[0]);

    }
}
