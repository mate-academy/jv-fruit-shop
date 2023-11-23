package main.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> reportData = new HashMap<>();

    public void setReportData(Map<String, Integer> reportData) {
        this.reportData = reportData;
    }

    public Map<String, Integer> getReportData() {
        return reportData;
    }
}
