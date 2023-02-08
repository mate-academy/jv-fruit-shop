package core.basesyntax.service.reader;

import java.util.List;

public interface InputParsingFormatterCsv {
    List<String> parsingFilesCsv(String pathFromRepository);
}
