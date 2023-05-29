package service;

import java.util.HashMap;

public interface ReportService {
    HashMap<String, Integer> createReportToStoreDB();

    String getReportStringForWriting(HashMap<String, Integer> storedCurrentFriutBalance);
}
