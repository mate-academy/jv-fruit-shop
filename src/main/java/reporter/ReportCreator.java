package reporter;

import java.util.Map;

public interface ReportCreator {
    Map<String, Integer> createPreReport(String filepath);

    void createReport(String filepath, String toFilepath);
}
