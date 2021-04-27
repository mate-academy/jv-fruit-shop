package core.basesyntax.validator.length;

public class ValidateLineLengthImpl implements ValidateLineLength {
    @Override
    public void isLengthCorrect(String[] line, int lineNumber) {
        try {
            if (line.length != 3) {
                throw new LineHasNotThreeWords();
            }
        } catch (LineHasNotThreeWords e) {
            throw new RuntimeException(
                    "Line " + lineNumber
                            + " has more or less than three arguments", e);
        }
    }
}
