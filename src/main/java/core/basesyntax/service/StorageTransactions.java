package core.basesyntax.service;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface StorageTransactions {
    List<String[]> convertFileIntoList(File inputFile);

    File sentReport(String data);

    String formingReport(Map<String, Integer> info);
}
