import core.basesyntax.dao.ReportsDao;
import core.basesyntax.dao.ReportsDaoImpl;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FileServiceImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;

public class Main {
    public static void main(String[] args) {
        ReportsDao reportsDao = new ReportsDaoImpl();
        FileService fileService = new FileServiceImpl();
        ReportService reportService = new ReportServiceImpl(reportsDao, fileService);
        reportService.generateReport("2022.01.02");
    }
}
