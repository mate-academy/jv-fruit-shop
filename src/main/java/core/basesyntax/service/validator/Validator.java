package core.basesyntax.service.validator;

import core.basesyntax.dao.FruitRecordDto;
import core.basesyntax.exceptions.IncorectOperationException;
import core.basesyntax.exceptions.IncorrectPurchaseRequestException;
import core.basesyntax.model.OperationType;

public class Validator {
    public static void canDoPurchase(int newValue, int oldValue, FruitRecordDto fruit) {
        if (newValue < 0) {
            throw new IncorrectPurchaseRequestException("You can't buy "
                    + fruit.getQuantity() + " " + fruit.getFruitName()
                    + "'s because it left not enough(" + oldValue + ")");
        }
    }

    public static boolean isValidLine(String[] line) {
        try {
            if (OperationType.getType(line[0]).name().length() > 0) {
                return true;
            }
        } catch (IncorectOperationException e) {
            return false;
        }
        return false;
    }
}
