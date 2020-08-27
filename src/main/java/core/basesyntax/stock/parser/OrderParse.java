package core.basesyntax.stock.parser;

public class OrderParse {
    public String[] parse(String row) {
        String[] line = row.split(",");
        if (line.length == 0) {
            throw new NullPointerException("Wrong argument format!");
        }
        return line;
    }
}
