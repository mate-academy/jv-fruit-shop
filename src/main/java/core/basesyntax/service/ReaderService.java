package core.basesyntax.service;

import core.basesyntax.model.Record;
import java.util.Queue;

public interface ReaderService {
    Queue<Record> read(String fileName);
}
