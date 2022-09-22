package core.basesyntax.service;

import core.basesyntax.db.Storage;

import java.util.List;

public interface WriterService {
    List<String> writeToFile();
}
