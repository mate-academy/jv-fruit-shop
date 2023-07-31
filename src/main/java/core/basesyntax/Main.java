package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import core.basesyntax.service.impl.CsvReaderService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.impl.ParserImpl;
import java.util.List;

public class Main {
    private static final ReaderService READER_SERVICE = new CsvReaderService();
    private static final Parser PARSER_SERVICE = new ParserImpl();
    private static final String INPUT_FILE_PATH = "src/main/resources/CsvInputData.csv";

    public static void main(String[] args) {
        List<String> fileData = READER_SERVICE.read(INPUT_FILE_PATH);
        List<FruitTransaction> parsedFile = PARSER_SERVICE.parse(fileData);

    }
}
