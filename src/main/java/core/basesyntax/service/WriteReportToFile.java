package core.basesyntax.service;

import java.util.Map;

public interface WriteReportToFile {
    int writeReportIntoFile(String fileTo, Map<String,Integer> map);
}
