package core.basesyntax.processdata.createreport;

import java.util.List;
import java.util.Map;

public interface Report {
    List<String> createReport(Map<String, Integer> stock);
}
