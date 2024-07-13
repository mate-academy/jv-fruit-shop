package service.impl;

import service.DataConverter;

public class DataConverterGetter {
    public static DataConverter getDataConverter() {
        return new DataConverterImpl();
    }
}
