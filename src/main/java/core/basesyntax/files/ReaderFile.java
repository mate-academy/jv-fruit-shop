package core.basesyntax.files;

import java.util.List;

public interface ReaderFile {
    List<String> getLinesFromFile(String fileName);
}
