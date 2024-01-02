package core.basesyntax.service;

import java.util.List;

public interface FileService {
    public List<String> readFile(String INPUT_FILE);
    public void writeToFile(String REPORT_FILE, String report);
}
