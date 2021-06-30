package core.basesyntax.services.interfaces;

import java.util.List;

public interface FileReader {
    List<String> getLinesFromFile(String fileName);
}
