package serviceImpl;

import service.DataConverter;

public class DataConverterGetter {
    public static DataConverter getDataConverter() {
        return new DataConverterImpl();
    }
}
