package core.basesyntax;

import java.util.List;
import service.ProcessDataService;
import service.ReadDataService;
import service.ReportGenerateService;
import service.WriteReportService;
import service.impl.ProcessDataServiceImpl;
import service.impl.ReadDataServiceImpl;
import service.impl.ReportGenerateServiceImpl;
import service.impl.WriteReportServiceImpl;

public class Main {
    public static final String INPUT_FILE = "src/main/resources/inputFile.csv";
    public static final String REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReadDataService readData = new ReadDataServiceImpl();
        ProcessDataService processData = new ProcessDataServiceImpl();
        ReportGenerateService reportGenerate = new ReportGenerateServiceImpl();
        WriteReportService writeReport = new WriteReportServiceImpl();

        final List<String[]> read = readData.read(INPUT_FILE);
        processData.getData(read);
        String report = reportGenerate.createMessage();
        writeReport.writeReport(report, REPORT_FILE);
    }
}
