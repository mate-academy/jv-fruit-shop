package core.basesyntax;
/*
    + Read an input file, handle exception, store data in storage;
    - Process data by specified storage keys, checking lines for consistent data "[bspr],\w++,\d++";
    - Throw exception if data is inconsistent or fruit doesn't match with shop product range;
    + Form a String report from calculated data in storage;
    + Write the report in ThisDayBalance.csv, make sure to overwrite it.
*/

import logic.MainLogic;
import logic.MainLogicImpl;

public class Launcher {
    private static final String MONDAY_FILE_PATH = "./res/IncomingReports/Monday.csv";
    private static final String REPORT_FILE_PATH = "./res/OutGoingReports/Report.csv";
    private static final MainLogic mainLogic = new MainLogicImpl();

    public static void main(String[] args) {
        System.out.println("Starting report... \n");

        mainLogic.generateReport(MONDAY_FILE_PATH, REPORT_FILE_PATH);

        System.out.println("Report creation finished, check " + REPORT_FILE_PATH);
    }
}
