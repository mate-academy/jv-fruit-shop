package core.basesyntax.fileservice;

import java.nio.file.Path;
import java.util.List;

public interface FileService {
    List<String> readFromFile(Path path);

    boolean writeToFile(List<String> dataList, Path fileTo);
}
