package core.basesyntax.service;

import java.util.List;

public interface CsvValidator {
    List<String> validate(List<String> records);
}
