package fruitshop.service.validators;

import java.util.List;

public class ValidatorImpl implements OperationsValidator {
    private static final String EMPTY_INPUT_FILE_NOTIFICATION
            = "Invalid Data. Input file is empty";
    private static final String EMPTY_DATA_LINE_NOTIFICATION
            = "Operation info is null, please change input";
    private static final String NOT_FULL_OPERATION_INFO_NOTIFICATION
            = "Invalid Data. Not enough information about operation and details";
    private static final String PROBLEM_WITH_AMOUNT_DATA_NOTIFICATION
            = "Invalid Data. Not Enough information about amount, or it`s invalid";
    private static final String SIGN_TO_SPLIT_WITH = ",";
    private static final String MINUS = "-";
    private static final int FRUIT_AMOUNT_RECORD = 2;
    private static final int NECESSARY_RECORD_PARTS = 3;

    public List<String> validator(List<String> uncheckedInfo) throws InvalidDataException {
        if (uncheckedInfo.isEmpty()) {
            throw new InvalidDataException(EMPTY_INPUT_FILE_NOTIFICATION);
        }
        for (String line: uncheckedInfo) {
            if (line == null || line.isEmpty()) {
                throw new InvalidDataException(EMPTY_DATA_LINE_NOTIFICATION);
            }
            if (line.split(",").length != NECESSARY_RECORD_PARTS) {
                throw new InvalidDataException(NOT_FULL_OPERATION_INFO_NOTIFICATION);
            }
            if (line.split(SIGN_TO_SPLIT_WITH)[FRUIT_AMOUNT_RECORD] == null
                    || line.split(SIGN_TO_SPLIT_WITH)[2].isEmpty()
                    || line.split(SIGN_TO_SPLIT_WITH)[FRUIT_AMOUNT_RECORD].contains(MINUS)) {
                throw new InvalidDataException(PROBLEM_WITH_AMOUNT_DATA_NOTIFICATION);
            }
        }
        return uncheckedInfo;
    }
}
