package core.service;

import java.util.List;

public interface WriterService {
    void writeToFile(List<String> report, String reportFileName);
}
