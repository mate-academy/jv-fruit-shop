package reporter;

import java.util.Map;

public interface ReportCreator {
    Map<String, Integer> createPreReport(String filepath);
    boolean createReport(String filepath, String toFilepath);
}
