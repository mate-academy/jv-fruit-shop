package core.basesyntax;

import core.basesyntax.dao.DataFromCsvFilrImpl;
import core.basesyntax.dao.DataToCsvFile;
import core.basesyntax.dao.DataToCsvFileImpl;
import core.basesyntax.service.DailyReport;
import core.basesyntax.service.FruitTransaction;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataFromCsvFilrImpl dataFromCsv = new DataFromCsvFilrImpl();
        List<FruitTransaction> fruitTransactions =
                dataFromCsv.readFileToList("src/main/resources/fullreport.csv");
        DailyReport dailyReport = new DailyReport();
        List<String> stringsReport = dailyReport.listOperation(fruitTransactions);
        DataToCsvFile dataToCsvFile = new DataToCsvFileImpl();
        dataToCsvFile.generateListToWriteFile(stringsReport);

    }
}
