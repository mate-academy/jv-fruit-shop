package core.basesyntex.service.impl;

import core.basesyntex.service.DataConverter;

public class DataConverterGetter {
    public static DataConverter getDataConverter() {
        return new DataConverterImpl();
    }
}
