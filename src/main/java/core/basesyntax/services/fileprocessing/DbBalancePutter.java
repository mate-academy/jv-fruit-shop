package core.basesyntax.services.fileprocessing;

import java.util.List;

public interface DbBalancePutter {
    List<String[]> getBalanceData(List<String> rawData);

    void putBalanceDataToDb(List<String[]> toDb);
}
