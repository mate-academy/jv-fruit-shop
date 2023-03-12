package core.basesyntax;
/*
    + Read an input file, handle exception, store data in storage;
    + Process data by specified storage keys;
    + Check lines for consistent data "[bspr],\w++,\d++";
    + Form a String report from calculated data in storage;
    + Write the report in "./res/OutGoingReports/Report.csv", make sure to overwrite it.
*/

import logic.MainLogic;
import logic.MainLogicImpl;

public class Launcher {
    private static final String TWO_FRUITS_FILE = "./res/IncomingReports/TwoFruits.csv";
    private static final MainLogic mainLogic = new MainLogicImpl();

    public static void main(String[] args) {
        mainLogic.generateReport(TWO_FRUITS_FILE);
    }
}
