package core.service.writer;

import java.util.List;

public interface ReportWriter {
    void write(List<String> strings, String filePath);
}
