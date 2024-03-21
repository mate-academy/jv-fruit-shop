package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.exception.InvalidFruitTypeException;
import core.basesyntax.exception.InvalidQuantityException;
import core.basesyntax.service.DataValidator;

public class DataValidatorImpl implements DataValidator {
    private static final String ILLEGAL_CHARACTERS = ".*\\d.*";

    @Override
    public void validate(FruitTransactionDto fruitTransactionDto) {
        validateFruitType(fruitTransactionDto);
        validateQuantity(fruitTransactionDto);

    }

    @Override
    public void validateFruitType(FruitTransactionDto fruitTransactionDto) {
        String fruitName = fruitTransactionDto.fruit();
        if (fruitName.matches(ILLEGAL_CHARACTERS)) {
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
