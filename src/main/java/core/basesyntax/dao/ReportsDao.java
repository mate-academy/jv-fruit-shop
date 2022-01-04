package core.basesyntax.dao;

import java.io.File;

//Data access object
public interface ReportsDao {

    void addReport(File report);

    //The current input file is sent to the program in CSV format
    File getInputFile(String date);

    //information about which is recorded in a file during the day.
    void updateReport(File report);

    String getReportFullPath(String date);
}
