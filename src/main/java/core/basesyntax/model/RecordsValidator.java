package core.basesyntax.model;

import java.util.List;

public interface RecordsValidator {
    List<Record> validateInput(String sourceFilename);
}
