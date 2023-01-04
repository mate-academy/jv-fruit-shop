package core.basesyntax.strategy;

import java.util.List;

public interface FileService {
    List<String> readFile(String fileName);

    boolean writeToFile(String data, String fileName);
}
