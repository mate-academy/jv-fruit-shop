package core.basesyntax;

import java.util.List;

public interface ReadableFile {
    boolean checkDataFormat(String[] lineFromFile, List<List<String>> fileData);
}
