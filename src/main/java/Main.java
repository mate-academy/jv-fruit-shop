import core.basesyntax.dao.FruitDaoCsvImpl;
import core.basesyntax.dao.WriteReportImpl;
import core.basesyntax.db.FruitDataBaseImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.services.OperationsServiceImpl;
import core.basesyntax.services.ReadDataImp;
import core.basesyntax.services.ReportServiceImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src\\main\\resources\\inputFile.csv";
    private static final String REPORT_FILE = "src\\main\\resources\\reportFile.csv";

    public static void main(String[] args) {
        FruitDaoCsvImpl fruitDaoCsv = new FruitDaoCsvImpl(INPUT_FILE);
        ReadDataImp readDataImp = new ReadDataImp(fruitDaoCsv);
        FruitDataBaseImpl fruitDataBase = new FruitDataBaseImpl(readDataImp);
        OperationsServiceImpl operationsService = new OperationsServiceImpl();
        Map<Fruit, Integer> fruitIntegerMap = operationsService.countingActivities(fruitDataBase);
        ReportServiceImpl reportService = new ReportServiceImpl();
        List<String> report = reportService.createReport(fruitIntegerMap);
        WriteReportImpl writeReport = new WriteReportImpl(REPORT_FILE);
        writeReport.write(report);
    }
}
