package dao;

import java.util.List;

public interface ReportCsvDao {
    List<String> getActionsOfDay();

    void setReport(List<String> report);
}
