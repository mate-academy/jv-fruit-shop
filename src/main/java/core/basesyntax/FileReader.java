package core.basesyntax;

import java.util.List;

public interface FileReader {
    List<String> readTransactions(String filePath);
}
