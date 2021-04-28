package core.basesyntax.validator.length;

public class ValidateLineLengthImpl implements ValidateLineLength {
    private static final int CORRECT_LENGTH = 3;

    @Override
    public void isLengthCorrect(String[] line, int lineNumber) {
        try {
            if (line.length != CORRECT_LENGTH) {
                throw new LineHasNotThreeWords();
            }
        } catch (LineHasNotThreeWords e) {
            throw new RuntimeException(
                    "Line " + lineNumber
                            + " has more or less than three arguments", e);
        }
    }
}
