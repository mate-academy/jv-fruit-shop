package core.basesyntax;

import core.basesyntax.service.data.DataServiceCsv;
import core.basesyntax.service.file.FileReaderCsv;
import core.basesyntax.service.reports.DailyTotals;
import java.util.List;

public class FruitShop {
    private static final String DAILY_DATA_PATH = "src/main/resources/dailyActivities.csv";
    private static final String DAILY_TOTAL_REPORT_PATH = "src/main/resources/dailyRestTotals.csv";

    public static void main(String[] args) {
        //upload data from csv file
        List<String> activities = new FileReaderCsv().readFile(DAILY_DATA_PATH);
        //process data
        new DataServiceCsv().processData(activities);
        //creating report
        new DailyTotals().create(DAILY_TOTAL_REPORT_PATH);
    }
}
