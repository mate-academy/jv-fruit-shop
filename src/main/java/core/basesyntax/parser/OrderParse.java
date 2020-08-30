package core.basesyntax.parser;

public class OrderParse implements ParseOperation {
    public String[] parse(String row) {
        String[] line = row.split(",");
        if (line.length == 0) {
            throw new RuntimeException("Wrong argument format!");
        }
        return line;
    }
}
