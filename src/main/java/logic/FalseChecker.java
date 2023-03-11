package logic;

import java.util.Map;
import java.util.Set;
import model.ReportException;
import service.impl.DataStorageServiceImpl;

public class FalseChecker {
    private static final Set<Map.Entry<String, Integer>> ENTRIES =
            new DataStorageServiceImpl().getFruitMap().entrySet();

    public static boolean checkData() {
        for (Map.Entry<String, Integer> e : ENTRIES) {
            if (e.getValue() < 0) {
                throw new ReportException("Input data falsified! Negative value for " + e.getKey());
            }
        }
        return true;
    }
}
