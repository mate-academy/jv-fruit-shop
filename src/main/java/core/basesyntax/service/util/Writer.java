package core.basesyntax.service.util;

import java.util.List;

public interface Writer {
    void writeToFile(List<String> content, String fileName);
}
