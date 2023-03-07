package core.basesyntax.service;

import core.basesyntax.model.FruitDto;
import java.util.List;

public interface ReportService {
    String createReport(List<FruitDto> fruits);
}
