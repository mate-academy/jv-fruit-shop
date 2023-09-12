package database;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> REPORT_LIST = new HashMap<>();

    public Map<String, Integer> getReportList() {
        return REPORT_LIST;
    }
}
