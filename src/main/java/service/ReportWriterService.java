package service;

import java.util.List;

public interface ReportWriterService {
    void writeReport(List<String> reports, String toFile);
}
