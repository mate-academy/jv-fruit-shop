package core.basesyntax.servise.inrterfase;

import core.basesyntax.servise.FruitRecordDto;
import java.util.List;

public interface ReportSplitter {
    List<FruitRecordDto> splitOfReport(List<String> report);
}
