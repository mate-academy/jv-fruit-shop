import java.util.List;
import model.FruitTransaction;
import service.OperationService;
import service.ParseService;
import service.ReadFileService;
import service.ReportService;
import service.impl.OperationServiceImpl;
import service.impl.ParseServiceImpl;
import service.impl.ReadFileServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriteFileServiceImpl;

public class Main {
    private static final String FROM_FILE = "src/main/resources/input.csv";
    private static final String TO_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReadFileService readService = new ReadFileServiceImpl();
        List<String> readFile = readService.read(FROM_FILE);
        ParseService parseService = new ParseServiceImpl();
        List<FruitTransaction> infoFromFile = parseService.getInfo(readFile);
        OperationService operationService = new OperationServiceImpl();
        operationService.calculate(infoFromFile);
        ReportService reportService = new ReportServiceImpl();
        String reportedInformation = reportService.report();
        new WriteFileServiceImpl().write(reportedInformation, TO_FILE);
    }
}
