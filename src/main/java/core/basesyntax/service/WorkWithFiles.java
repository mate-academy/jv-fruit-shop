package core.basesyntax.service;

import java.util.List;

public interface WorkWithFiles {
    List<String> readFromFile(String filePass);

    void writeToFile(String filePass, String content);
}
