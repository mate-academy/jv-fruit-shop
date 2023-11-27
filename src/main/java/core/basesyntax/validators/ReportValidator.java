package core.basesyntax.validators;

public class ReportValidator {
    public void validate(int amount) {
        if (amount < 0) {
            throw new RuntimeException("Negative result. Check input data!");
        }
    }
}
