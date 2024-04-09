package db;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final List<String> FRUITS_BALANCE_REPORT = new ArrayList<>();

    public static List<String> getFruitsBalanceReport() {
        return new ArrayList<>(FRUITS_BALANCE_REPORT);
    }

    public static void saveToFruitsBalanceReport(String reportData) {
        FRUITS_BALANCE_REPORT.add(reportData);

    }
}
