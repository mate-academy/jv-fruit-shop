package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface FileService {
    List<String> readFromFile(String fileName);

    boolean createReport(Map<String, Integer> map, String fileName);
}
