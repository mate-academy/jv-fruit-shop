package processor;

import java.util.Map;
import java.util.Set;
import model.ReportException;
import service.impl.DataStorageServiceImpl;

@Deprecated
public class FalseCheckUnitImpl implements FalseCheckUnit {
    private static final Set<Map.Entry<String, Integer>> ENTRIES =
            new DataStorageServiceImpl().getFruitMap().entrySet();

    public boolean checkData() {
        for (Map.Entry<String, Integer> e : ENTRIES) {
            if (e.getValue() < 0) {
                throw new ReportException("Input data falsified! Negative amount calculated for "
                        + e.getKey());
            }
        }
        return true;
    }
}
