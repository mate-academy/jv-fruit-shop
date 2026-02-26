package core.basesyntax.parser;

public class FruitTransactionValidator {

    public ValidationResult validate(String line, int rowIndex) {

        if (line == null || line.isBlank()) {
            return ValidationResult.fail("Row " + rowIndex + ": empty line");
        }

        String[] split = line.split(",");

        if (split.length != 3) {
            return ValidationResult.fail(
                    "Row " + rowIndex + ": expected 3 columns but got " + split.length
            );
        }

        String type = split[0].trim();
        String fruit = split[1].trim();
        String quantityStr = split[2].trim();

        if (type.isEmpty()) {
            return ValidationResult.fail("Row " + rowIndex + ": type is empty");
        }

        if (fruit.isEmpty()) {
            return ValidationResult.fail("Row " + rowIndex + ": fruit is empty");
        }

        try {
            int quantity = Integer.parseInt(quantityStr);
            if (quantity < 0) {
                return ValidationResult.fail(
                        "Row " + rowIndex + ": quantity must be >= 0"
                );
            }
        } catch (NumberFormatException e) {
            return ValidationResult.fail(
                    "Row " + rowIndex + ": quantity is not a number -> " + quantityStr
            );
        }

        return ValidationResult.ok();
    }
}
