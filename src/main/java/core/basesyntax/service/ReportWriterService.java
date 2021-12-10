package core.basesyntax.service;

import java.util.List;

public interface ReportWriterService {
    void write(List<String> report, String toFileName);
}
