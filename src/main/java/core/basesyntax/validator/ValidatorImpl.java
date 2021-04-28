package core.basesyntax.validator;

import core.basesyntax.validator.length.LineLengthValidator;
import core.basesyntax.validator.quantity.QuantityValidator;
import core.basesyntax.validator.type.TypeValidator;

public class ValidatorImpl implements Validator {
    private final LineLengthValidator lineLengthValidator;
    private final TypeValidator typeValidator;
    private final QuantityValidator quantityValidator;

    public ValidatorImpl(LineLengthValidator lineLengthValidator, TypeValidator typeValidator,
                         QuantityValidator quantityValidator) {
       this.lineLengthValidator = lineLengthValidator;
       this.typeValidator = typeValidator;
       this.quantityValidator = quantityValidator;
    }

    @Override
    public void validateLine(String[] line, int lineNumber) {
        lineLengthValidator.isLengthCorrect(line, lineNumber);
        typeValidator.isTypeCorrect(line[0], lineNumber);
        quantityValidator.isQuantityLessThanZero(Long.parseLong(line[2]), lineNumber);
    }
}
