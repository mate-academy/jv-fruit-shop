package core.basesyntax.service;

import core.basesyntax.model.Record;
import java.util.Queue;

public interface ProcessorService {
    void process(Queue<Record> records);
}
