package util;

public class DataConverterGetter {
    public static DataConverter getDataConverter() {
        return new DataConverterImpl();
    }
}
