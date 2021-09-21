package service;

import java.util.List;

public interface WriterService {
    void writeReportToCsv(List<String> report, String filename);
}
