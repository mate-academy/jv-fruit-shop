package core.basesyntax.filevalidatorservice;

public interface FileValidator extends Validator {
    boolean validateFile(String path);

}
