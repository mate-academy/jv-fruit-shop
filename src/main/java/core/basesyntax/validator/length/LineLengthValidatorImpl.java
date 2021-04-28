package core.basesyntax.validator.length;

public class LineLengthValidatorImpl implements LineLengthValidator {
    private static final int CORRECT_LENGTH = 3;

    @Override
    public void isLengthCorrect(String[] line, int lineNumber) {
        if (line.length != CORRECT_LENGTH) {
            throw new LineHasNotThreeWordsException("Line " + lineNumber
                    + " has more or less than three arguments");
        }
    }
}
