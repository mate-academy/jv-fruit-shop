package core.basesyntax.service.impl;

import core.basesyntax.record.Record;
import core.basesyntax.service.DataConverter;
import core.basesyntax.strategy.RecordMapperStrategy;
import core.basesyntax.strategy.impl.RecordMapperStrategyImpl;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final RecordMapperStrategy recordMapperStrategy = new RecordMapperStrategyImpl();
    private static final int NAMES_OF_COLUMNS = 0;
    private static final int PRODUCT_INDEX = 1;
    private static final String COMMA = ",";

    @Override
    public List<Record> convert(List<String> data) {
        return recordMapperStrategy
                .get(getProductType(data))
                .getRecordsFromLines(data);
    }

    private String getProductType(List<String> linesFromFile) {
        String[] namesOfColumns = linesFromFile.remove(NAMES_OF_COLUMNS).split(COMMA);
        return namesOfColumns[PRODUCT_INDEX];
    }
}
