package core.basesyntax.service;

import java.io.BufferedWriter;

public interface ReportService {
    String getReport();

    void writeHeaders(BufferedWriter bufferedWriter);
}
