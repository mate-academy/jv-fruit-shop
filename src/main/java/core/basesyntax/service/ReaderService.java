package core.basesyntax.service;

import core.basesyntax.model.ProductTransaction;
import java.nio.file.Path;
import java.util.Queue;

public interface ReaderService {
    Queue<ProductTransaction> read(Path fileName);
}
