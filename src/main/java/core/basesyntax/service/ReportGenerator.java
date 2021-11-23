package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.List;

public interface ReportGenerator {
    List<String> generate(Storage storage);
}
