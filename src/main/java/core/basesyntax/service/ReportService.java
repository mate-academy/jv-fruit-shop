package core.basesyntax.service;

import core.basesyntax.model.ReportRecord;
import java.util.List;

public interface ReportService {
    List<ReportRecord> generate();
}
