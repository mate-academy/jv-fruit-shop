package core.basesyntax.service;

import core.basesyntax.model.ProductTransaction;
import java.util.Queue;

public interface ProcessorService {
    void processing(Queue<ProductTransaction> productTransactions);

    String report();
}
