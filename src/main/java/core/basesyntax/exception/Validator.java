package core.basesyntax.exception;

import java.util.List;

public interface Validator {
    boolean checkFile(List<String> readFile);
}
