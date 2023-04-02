import core.basesyntax.model.Transaction;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.Parser;
import core.basesyntax.service.impl.ParserImplCSV;
import core.basesyntax.service.impl.DataReaderImpl;

import java.util.List;

public class Main {
    public static final String FILE_NAME = "src/main/resources/test.csv";
    public static final String CSV_PARSER_DELIMITER = ",";

    public static void main(String[] args) {
        DataReader reader = new DataReaderImpl();
        List<String> linesFromCSV = reader.read(FILE_NAME);
        Parser<Transaction> parser = new ParserImplCSV().setDelimiter(CSV_PARSER_DELIMITER);
        List<Transaction> parsedLines = parser.parse(linesFromCSV);
        System.out.println(parsedLines);
    }

}
