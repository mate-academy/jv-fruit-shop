
import dao.ReaderService;
import dao.ReaderServiceImp;
import dao.WriterService;
import dao.WriterServiceImp;
import java.util.List;
import service.ReportService;
import service.ReportServiceImp;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImp();
        WriterService writerService = new WriterServiceImp();
        ReportService reportService = new ReportServiceImp();

        String filePath = "src/main/resources/activities_day_one.csv";
        List<String> strings = readerService.readFromFile(filePath);
        List<String> reportList = reportService.makeBalanceReport(strings);
        writerService.writeToFile(reportList);
    }
}
