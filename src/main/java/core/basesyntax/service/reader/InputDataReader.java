package core.basesyntax.service.reader;

import java.util.List;

public interface InputDataReader {
    List<String> getDataFromFile(String inputFilePath);
}
