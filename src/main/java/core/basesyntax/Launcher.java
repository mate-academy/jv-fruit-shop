package core.basesyntax;

import logic.MainLogic;
import logic.MainLogicImpl;

public class Launcher {
    private static final String TWO_FRUITS_FILE
            = "src/main/resources/IncomingReports/TwoFruits.csv";
    private static MainLogic mainLogic;

    public static void main(String[] args) {
        mainLogic = new MainLogicImpl(TWO_FRUITS_FILE);
        mainLogic.generateReport();
    }
}
