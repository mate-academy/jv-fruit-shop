package core.basesyntax.service;

public class InputDataValidatorImpl implements InputDataValidator<String> {
    public static final String CSV_SEPARATOR = ",";
    public static final String OPERATIONS = "sbrp";
    public static final int OPERATION_TYPE = 0;
    public static final int FRUIT_NAME = 1;
    public static final int FRUIT_AMOUNT = 2;
    private String[] threeElements;

    @Override
    public String[] validate(String fruitRecord) throws InputDataErrorException {
        if (fruitRecord == null) {
            throw new InputDataErrorException("Can't work with empty line:" + fruitRecord);
        }
        threeElements = fruitRecord.split(CSV_SEPARATOR);
        if (threeElements.length != 3) {
            throw new InputDataErrorException("We need 3 data fields from "
                    + "a file line operation,friut_type,quantity" + fruitRecord);
        }
        if (!OPERATIONS.contains(threeElements[OPERATION_TYPE])) {
            throw new InputDataErrorException("Can't operate "
                    + "unknown operation of a fruit shop" + fruitRecord);
        }
        if (Integer.parseInt(threeElements[FRUIT_AMOUNT]) < 0) {
            throw new InputDataErrorException("Quantity of fruit "
                    + "can't be fewer than 0" + fruitRecord);
        }
        if (!threeElements[FRUIT_NAME].matches("[a-zA-Z]+")) {
            throw new InputDataErrorException("This is not "
                    + "an alphabetic sort fruit " + fruitRecord);
        }
        return threeElements;
    }
}
