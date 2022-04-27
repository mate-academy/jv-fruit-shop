import java.util.List;
import model.FruitTransaction;
import service.OperationService;
import service.ParseService;
import service.ReadFile;
import service.ReportService;
import service.impl.OperationServiceImpl;
import service.impl.ParseServiceImpl;
import service.impl.ReadFileImpl;
import service.impl.ReportServiceImpl;
import service.impl.WritFileImpl;

public class Main {
    public static void main(String[] args) {
        ReadFile read = new ReadFileImpl();
        List<String> readFile = read.read();
        ParseService parseService = new ParseServiceImpl();
        List<FruitTransaction> infoFromFile = parseService.getInfo(readFile);
        OperationService operationService = new OperationServiceImpl();
        operationService.calculate(infoFromFile);
        ReportService reportService = new ReportServiceImpl();
        String reportedInformation = reportService.report();
        new WritFileImpl().write(reportedInformation);
    }
}
