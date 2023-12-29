package core.basesyntax.functional;

import java.util.List;
import java.util.Map;

public interface Function {
    void extractBalance(List<String[]> list);

    void checkPositiveValueOfBalance(int i);

    String fomReport(Map<String, String> map);

}
