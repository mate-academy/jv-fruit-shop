package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.exception.InvalidFruitTypeException;
import core.basesyntax.exception.InvalidOperationException;
import core.basesyntax.exception.InvalidQuantityException;
import core.basesyntax.service.DataValidator;

public class DataValidatorImpl implements DataValidator {
    private static final String BALANCE = FruitDataParser.Operation.BALANCE.getCode();
    private static final String SUPPLY = FruitDataParser.Operation.SUPPLY.getCode();
    private static final String RETURN = FruitDataParser.Operation.RETURN.getCode();
    private static final String PURCHASE = FruitDataParser.Operation.PURCHASE.getCode();
    private static final String SPECIAL_CHARACTERS = ".*[$&+,/:;=?@#|'<>.-^*()%!].*";

    @Override
    public void validate(FruitTransactionDto fruitTransactionDto) {
        validateFruitType(fruitTransactionDto);
        validateOperation(fruitTransactionDto);
        validateQuantity(fruitTransactionDto);

    }

    @Override
    public void validateOperation(FruitTransactionDto fruitTransactionDto) {
        String operation = fruitTransactionDto.operation();

        if ((operation.equalsIgnoreCase(BALANCE)
                || operation.equalsIgnoreCase(SUPPLY)
                || operation.equalsIgnoreCase(RETURN)
                || operation.equalsIgnoreCase(PURCHASE))) {
            return;
        }
        throw new InvalidOperationException("Invalid operation: " + operation);
    }

    @Override
    public void validateFruitType(FruitTransactionDto fruitTransactionDto) {
        String fruitName = fruitTransactionDto.fruit();
        if (fruitName.matches(SPECIAL_CHARACTERS)) {
            throw new InvalidFruitTypeException("Your fruit can't have special symbols "
                    + "or numbers, now: " + fruitName);
        }
    }

    @Override
    public void validateQuantity(FruitTransactionDto fruitTransactionDto) {
        if (fruitTransactionDto.quantity() < 0) {
            throw new InvalidQuantityException("Quantity of product can't be less than 0, now: "
                    + fruitTransactionDto.quantity());
        }
    }
}
