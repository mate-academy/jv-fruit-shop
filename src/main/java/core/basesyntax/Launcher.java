package core.basesyntax;
/*
    + Read an input file, handle exception, store data in storage;
    + Process data by specified storage keys;
    + Check lines for consistent data "[bspr],\w++,\d++";
    + Form a String report from calculated data in storage;
    + Write the report in ThisDayBalance.csv, make sure to overwrite it.
*/

import logic.MainLogic;
import logic.MainLogicImpl;

public class Launcher {
    private static final String TWO_FRUITS_FILE_PATH = "./res/IncomingReports/TwoFruits.csv";
    private static final String THREE_FRUITS_FILE_PATH = "./res/IncomingReports/ThreeFruits.csv";
    private static final String NO_BALANCE_FILE_PATH = "./res/IncomingReports/MissedBalance.csv";
    private static final String EMPTY_FILE_PATH = "./res/IncomingReports/EmptyInput.csv";
    private static final String BROKEN_FILE_PATH = "./res/IncomingReports/BrokenInput.csv";
    private static final String FALSE_DATA_FILE_PATH = "./res/IncomingReports/FalsifiedData.csv";
    private static final String REPORT_FILE_PATH = "./res/OutGoingReports/Report.csv";
    private static final MainLogic mainLogic = new MainLogicImpl();

    public static void main(String[] args) {
        //mainLogic.generateReport(TWO_FRUITS_FILE_PATH, REPORT_FILE_PATH);
        mainLogic.generateReport(THREE_FRUITS_FILE_PATH, REPORT_FILE_PATH);
        //mainLogic.generateReport(NO_BALANCE_FILE_PATH, REPORT_FILE_PATH);
        //mainLogic.generateReport(EMPTY_FILE_PATH, REPORT_FILE_PATH);
        //mainLogic.generateReport(BROKEN_FILE_PATH, REPORT_FILE_PATH);
        //mainLogic.generateReport(FALSE_DATA_FILE_PATH, REPORT_FILE_PATH);
    }
}
