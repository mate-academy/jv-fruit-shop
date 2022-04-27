import model.FruitTransaction;
import service.OperationService;
import service.ParseService;
import service.ReadCSVFile;
import service.ReportService;
import service.impl.OperationServiceImpl;
import service.impl.ParseServiceImpl;
import service.impl.ReadCSVFileImpl;
import service.impl.ReportServiceImpl;
import service.impl.WritToCSVFileImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadCSVFile read = new ReadCSVFileImpl();
        List<String> readFile = read.read();
        ParseService parseService = new ParseServiceImpl();
        List<FruitTransaction> infoFromFile = parseService.getInfo(readFile);
        OperationService operationService = new OperationServiceImpl();
        operationService.calculate(infoFromFile);
        ReportService reportService = new ReportServiceImpl();
        String reportedInformation = reportService.report();
        new WritToCSVFileImpl().write(reportedInformation);
    }
}
