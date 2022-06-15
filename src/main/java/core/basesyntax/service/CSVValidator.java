package core.basesyntax.service;

import java.util.List;

public interface CSVValidator {
    List<String> validate(List<String> records);
}
