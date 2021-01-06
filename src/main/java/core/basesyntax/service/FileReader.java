package core.basesyntax.service;

import core.basesyntax.model.Record;
import java.util.List;

public interface FileReader {
    List<Record> readAll(String path);
}
