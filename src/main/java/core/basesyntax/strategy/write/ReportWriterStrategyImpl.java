package core.basesyntax.strategy.write;

import core.basesyntax.model.WriterType;
import core.basesyntax.service.ReportWriterService;
import core.basesyntax.service.impl.ReportWriterServiceConsole;
import core.basesyntax.service.impl.ReportWriterServiceFile;

public class ReportWriterStrategyImpl implements ReportWriterStrategy {
    @Override
    public ReportWriterService get(final WriterType writerType) {
        switch (writerType) {
            case FILE:
                return new ReportWriterServiceFile();
            case CONSOLE:
                return new ReportWriterServiceConsole();
            default:
                throw new RuntimeException(ReportWriterService.UNKNOWN_WRITER_TYPE);
        }
    }
}
