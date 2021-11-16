package core.basesyntax.servise.inrterfase;

import core.basesyntax.servise.FruitRecordDto;
import java.util.List;

public interface ReportBuilder {
    List<FruitRecordDto> getReport(List<String> report);
}
