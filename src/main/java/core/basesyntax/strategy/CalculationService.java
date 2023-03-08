package core.basesyntax.strategy;

import java.util.List;

public interface CalculationService {
    void initializationStorage(List<String[]> convertedFileIntoList);

    void calculation(List<String[]> convertedFileIntoList);
}
