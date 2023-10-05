package core.basesyntax.service;

import java.util.List;

public interface ReportWriterService {
    String UNKNOWN_WRITER_TYPE = "Unknown writer type.";

    void writeReport(List<String> report);
}
