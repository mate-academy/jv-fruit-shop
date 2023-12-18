package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> shiftStatistics = new HashMap<>();

    public static Map<String, Integer> getShiftStatistics() {
        return shiftStatistics;
    }

    public static void setShiftStatistics(Map<String, Integer> shiftStatistics) {
        Storage.shiftStatistics = shiftStatistics;
    }
}
