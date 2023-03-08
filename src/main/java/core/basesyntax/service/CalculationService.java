package core.basesyntax.service;

import java.util.List;

public interface CalculationService {
    void initializationStorage(List<String> convertedFileIntoList);

    void calculation(List<String> convertedFileIntoList);
}
