package core.basesyntax.service;

import java.io.File;
import java.util.List;

public interface ReportService {

    File createNewReport(String date);

    //process these data
    //generate a report based on processed data
    List<String> doReport(List<String> records);

    void generateReport(String date);
}
