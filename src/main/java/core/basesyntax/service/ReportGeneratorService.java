package core.basesyntax.service;

import core.basesyntax.db.Storage;

public interface ReportGeneratorService {
    String generate(Storage storage);
}
