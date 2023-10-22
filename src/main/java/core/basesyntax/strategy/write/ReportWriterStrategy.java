package core.basesyntax.strategy.write;

import core.basesyntax.model.WriterType;
import core.basesyntax.service.ReportWriterService;

public interface ReportWriterStrategy {
    ReportWriterService get(WriterType writerType);
}
