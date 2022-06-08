package core.basesyntax.service;

import core.basesyntax.model.ProductTransaction;
import java.util.List;
import java.util.Queue;

public interface ParseService {
    Queue<ProductTransaction> parse(List<String> data);
}
