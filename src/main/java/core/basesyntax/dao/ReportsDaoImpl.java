package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReportsDaoImpl implements ReportsDao {

    public static final String REPORTS_FOLDER_PATH = getReportsFolderPath();
    public static final String INPUT_FILENAME_SUFFIX = " input file.csv";
    public static final String REPORT_FILENAME_SUFFIX = " report file.csv";

    public ReportsDaoImpl() {
        Storage.reports.addAll(getListOfReports());
    }

    @Override
    public void addReport(File report) {
        Storage.reports.add(report);
    }

    @Override
    public File getInputFile(String date) {
        String inputFileName = date + INPUT_FILENAME_SUFFIX;
        return Storage.reports.stream()
                .filter(r -> r.getName().equals(inputFileName))
                .findFirst()
                .get();
    }

    @Override
    public void updateReport(File report) {
        File reportFromDB = getInputFile(report.getName());
        Storage.reports.remove(reportFromDB);
        addReport(report);
    }

    private List<File> getListOfReports() {
        String reportsPath = getReportsFolderPath();
        File reportsFolder = new File(reportsPath);
        File[] reports = reportsFolder.listFiles();
        //List<File> listOfReports = List.of(reports);
        List<File> listOfReports = new ArrayList<>();
        for (File report : reports) {
            if (report.isFile()) {
                listOfReports.add(report);
            }
        }
        return listOfReports;
    }

    private static String getReportsFolderPath() {
        String projectPath = System.getProperty("user.dir");
        String reportsPath = projectPath + "\\reports";//File.pathSeparator
        return reportsPath;
    }

    public String getInputFilename(String date) {
        return date + INPUT_FILENAME_SUFFIX;
    }

    public String getReportFullPath(String date) {
        return REPORTS_FOLDER_PATH + "\\" + date + REPORT_FILENAME_SUFFIX;
    }

}
