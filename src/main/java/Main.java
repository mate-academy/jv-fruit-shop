import java.util.List;
import java.util.Map;
import service.ProcessDataService;
import service.ReaderService;
import service.ReportGeneratingService;
import service.ReportWriterService;
import service.impl.ProcessDataServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportGeneratingServiceImpl;
import service.impl.ReportWriterServiceImpl;

public class Main {
    public static void main(String[] args) {
        String fromFile = "src/main/resources/from.csv";
        String toFile = "src/main/resources/to.csv";
        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromFile = readerService.readFile(fromFile);
        ProcessDataService processDataService = new ProcessDataServiceImpl();
        Map<String, Integer> db = processDataService.processData(dataFromFile);
        ReportGeneratingService reportGeneratingService = new ReportGeneratingServiceImpl();
        List<String> report = reportGeneratingService.createReport(db);
        ReportWriterService reportWriterService = new ReportWriterServiceImpl();
        reportWriterService.writeReport(report, toFile);
    }
}
