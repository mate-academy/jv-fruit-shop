package service;

import java.util.List;

public class ValidatorImpl implements Validator {
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_TYPE = 1;
    private static final int FRUIT_QUANTITY = 2;

    public void validate(List<String[]> splitedInformationList) {
        String[] columnsLine = splitedInformationList.get(0);
        try {
            if (!(columnsLine[OPERATION_TYPE].equals("type")
                    && columnsLine[FRUIT_TYPE].equals("fruit")
                    && columnsLine[FRUIT_QUANTITY].equals("quantity"))) {
                throw new RuntimeException("Input data is invalid at 1 line");
            }
            String[] splitLine;
            String operation;
            int amount;
            for (int i = 1; i < splitedInformationList.size(); i++) {
                splitLine = splitedInformationList.get(i);
                operation = splitLine[OPERATION_TYPE];
                amount = Integer.parseInt(splitLine[FRUIT_QUANTITY]);
                if (!(operation.equals("b") || operation.equals("p")
                        || operation.equals("s") || operation.equals("r"))) {
                    throw new RuntimeException("Operation type is invalid. Error at "
                            + i + " line");
                }
                if (amount < 0) {
                    throw new RuntimeException("Amount of fruit can't be less than 0. Error at "
                            + i + " line");
                }
            }
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Input data is invalid");
        }
    }
}
