package core.basesyntax.service;

import java.util.List;

public interface Writer {
    void writeToFile(List<String> list, String outputFilePathname);
}
