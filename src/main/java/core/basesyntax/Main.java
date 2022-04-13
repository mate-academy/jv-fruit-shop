package core.basesyntax;

import core.basesyntax.dao.CsvFileService;
import core.basesyntax.dao.CsvFilrImplService;
import core.basesyntax.dao.DataToCsvFile;
import core.basesyntax.dao.DataToCsvFileImpl;
import core.basesyntax.service.DailyReport;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.Storage;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CsvFileService dataFromCsv = new CsvFilrImplService();

        List<FruitTransaction> fruitTransactions =
                dataFromCsv.readFileToList("src/main/resources/fullreport.csv");
        Storage storage = new Storage();
        Map<String, Integer> mapStorage = storage.putFruitInStorage(fruitTransactions);
        DailyReport dailyReport = new DailyReport();
        List<String> stringsReport = dailyReport.listOperation(mapStorage);
        DataToCsvFile dataToCsvFile = new DataToCsvFileImpl();
        System.out.println(dataToCsvFile.generateListToWriteFile(
                stringsReport, "src/main/resources/daylireport.csv"));
    }
}
