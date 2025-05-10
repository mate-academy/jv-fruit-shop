package core.basesyntax.utils;

import core.basesyntax.model.ResultData;
import java.util.List;

public interface ReportGenerator {
    String getReport(List<ResultData> resultDataList);
}
