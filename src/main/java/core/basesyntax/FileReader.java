package core.basesyntax;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileReader {

    List<String> readFromFile(String filePath) throws FileNotFoundException;
}
