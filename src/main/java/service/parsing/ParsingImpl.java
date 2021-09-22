package service.parsing;

public class ParsingImpl implements Parsing {
    private static final String CSV_SEPARATOR = ",";

    @Override
    public String[] parsing(String data) {
        return data.split(CSV_SEPARATOR);
    }
}
