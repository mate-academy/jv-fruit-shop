package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface CheckDataService {
    void checkData(List<String> dataFromFileList);

    void checkingDataMapBeforeSavingToDb(Map<String, Integer> balanceMap);
}
