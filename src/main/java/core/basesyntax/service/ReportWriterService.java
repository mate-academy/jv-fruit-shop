package core.basesyntax.service;

import core.basesyntax.model.ReportRecord;
import java.util.List;

public interface ReportWriterService {
    void write(List<ReportRecord> records);
}
