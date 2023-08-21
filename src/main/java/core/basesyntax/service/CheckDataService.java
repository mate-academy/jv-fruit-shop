package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface CheckDataService {
    void checkData(List<String> dataFromFileList);

    void checkReport(Map<String, Integer> balanceMap);
}
