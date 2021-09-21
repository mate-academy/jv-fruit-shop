package core.basesyntax.exception;

public interface Validator {
    boolean checkFile(String[] fields, String line);
}
