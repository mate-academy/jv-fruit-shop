package core.basesyntax.servises;

public class ValidatorImpl implements Validator {
    private static final int ZERO = 0;
    private static final int TYPE = 0;
    private static final int QUANTITY = 2;
    private static final int LENGTH = 3;

    @Override
    public void validate(String[] rows) {
        if (rows.length != LENGTH) {
            throw new RuntimeException("Data is incorrect");
        }
        if (!"bprs".contains(rows[TYPE])) {
            throw new RuntimeException("OperationType isn't valid");
        }
        if ((Integer.parseInt(rows[QUANTITY]) < ZERO)) {
            throw new RuntimeException("Quantity is incorrect");
        }
    }
}


