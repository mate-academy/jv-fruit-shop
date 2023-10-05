package core.basesyntax.strategy.read;

import core.basesyntax.model.DataSourceType;
import core.basesyntax.service.InputReaderService;
import core.basesyntax.service.impl.InputReaderServiceCsvFile;

public class InputReaderStrategyImpl implements InputReaderStrategy {
    public static final String UNKNOWN_INPUT_SOURCE = "Unknown input source.";

    @Override
    public InputReaderService get(final DataSourceType dataSourceType) {
        switch (dataSourceType) {
            case CsvFile:
                return new InputReaderServiceCsvFile();
            default:
                throw new RuntimeException(UNKNOWN_INPUT_SOURCE);
        }
    }
}
