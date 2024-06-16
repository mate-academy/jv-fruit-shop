package core.basesyntax.reportservices;

import java.util.List;
import java.util.Map;

public interface ReportCreator {
    List<String> report(Map<String, Integer> transactions);
}
