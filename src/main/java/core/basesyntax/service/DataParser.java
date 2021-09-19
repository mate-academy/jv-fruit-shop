package core.basesyntax.service;

public class DataParser {
    private static final String SEPARATOR = ",";
    private static final int FIRST_VALUE = 0;
    private static final int SECOND_VALUE = 1;
    private static final int THIRD_VALUE = 2;
    public String[] fruitInfo(String data) {
        String[] fruitInfoArray = data.split(SEPARATOR);

    }
}
