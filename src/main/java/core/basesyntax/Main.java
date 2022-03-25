package core.basesyntax;

import core.basesyntax.dao.DataFromDbImpl;
import core.basesyntax.service.DailyReport;

public class Main {
    public static void main(String[] args) {
        DataFromDbImpl dataFromDb = new DataFromDbImpl();
        System.out.println(dataFromDb.readFileToMap());
        DailyReport dailyReport = new DailyReport();
        System.out.println(dailyReport.createListFronMap());
    }
}
