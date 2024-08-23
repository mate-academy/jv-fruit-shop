package core.basesyntax.utils.generate.impl;

import core.basesyntax.storage.impl.StorageImpl;
import core.basesyntax.utils.generate.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private final ReportGenerator generator;

    public ReportGeneratorImpl(ReportGenerator generator) {
        this.generator = generator;
    }

    @Override
    public String getReport(StorageImpl storage) {
          return generator.getReport(storage);
    }
}
