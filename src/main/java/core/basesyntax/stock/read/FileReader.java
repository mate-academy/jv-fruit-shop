package core.basesyntax.stock.read;

import java.util.List;

public interface FileReader {
    List<String> readFile(String filePath);
}
