package core.basesyntax.servise;

import core.basesyntax.validators.DataValidator;
import core.basesyntax.validators.ReportValidator;

import java.util.List;

public interface ReportService {
    String getReport(List<String> dataFromFile);
}
