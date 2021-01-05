package core.basesyntax.validation;

import core.basesyntax.model.Operation;

public class CsvValidator implements Validator {
    private boolean isBalanceArea = true;

    @Override
    public boolean isValidLine(String[] line) {
        if (line.length != 3) {
            throw new RuntimeException("Incorrect input file, record must contain "
                    + "`type`, `fruit` and `quantity`");
        }
        Operation type = Operation.getOperation(line[0]);
        return isValidType(type);
    }

    private boolean isValidType(Operation operation) {
        if (operation != Operation.BALANCE) {
            isBalanceArea = false;
        }
        if (operation == Operation.BALANCE && !isBalanceArea) {
            throw new RuntimeException("Balance fields must wil be in the top of file");
        }
        return true;
    }
}
