import dao.StorageDao;
import dao.StorageDaoImpl;
import java.util.List;
import model.FruitTransaction;
import service.OperationHandlerStrategy;
import service.OperationService;
import service.ParseService;
import service.ReadFileService;
import service.ReportService;
import service.impl.OperationHandlerStrategyImpl;
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
        StorageDao storageDao = new StorageDaoImpl();
        OperationHandlerStrategy operationHandlerStrategy = new OperationHandlerStrategyImpl();
        OperationService operationService = new OperationServiceImpl(operationHandlerStrategy);
        operationService.calculate(infoFromFile);
        ReportService reportService = new ReportServiceImpl(storageDao);
        String reportedInformation = reportService.report();
        new WriteFileServiceImpl().write(reportedInformation, TO_FILE);
    }
}
