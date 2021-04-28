package core.basesyntax.validator;

import core.basesyntax.validator.length.ValidateLineLength;
import core.basesyntax.validator.length.ValidateLineLengthImpl;
import core.basesyntax.validator.quantity.QuantityValidator;
import core.basesyntax.validator.quantity.QuantityValidatorImpl;
import core.basesyntax.validator.type.TypeValidator;
import core.basesyntax.validator.type.TypeValidatorImpl;

import java.util.Set;

public class ValidatorImpl implements Validator {
    ValidateLineLength validateLineLength;
    TypeValidator typeValidator;
    QuantityValidator quantityValidator;

    public ValidatorImpl() {
        validateLineLength = new ValidateLineLengthImpl();
        typeValidator = new TypeValidatorImpl();
        quantityValidator = new QuantityValidatorImpl();
    }

    @Override
    public void lineValidator(String[] line, int lineNumber) {
        validateLineLength.isLengthCorrect(line, lineNumber);
        //typeValidator.isTypeCorrect(line[0], lineNumber);
        quantityValidator.isQuantityLessThanZero(Long.parseLong(line[2]), lineNumber);
    }
}
