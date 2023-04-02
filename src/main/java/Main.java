import core.basesyntax.DataReader;
import core.basesyntax.Parser;
import core.basesyntax.service.impl.ParserImplCSV;
import core.basesyntax.service.impl.DataReaderImpl;

import java.util.List;

public class Main {
    public static final String FILE_NAME = "src/test.csv";
    public static final String CSV_PARSER_DELIMITER = ",";

    public static void main(String[] args) {
        DataReader reader = new DataReaderImpl();
        List<String> linesFromCSV = reader.read(FILE_NAME);
        Parser parser = new ParserImplCSV().setDelimiter(CSV_PARSER_DELIMITER);
        List<String[]> parsedData = parser.parse(linesFromCSV);
    }

}
