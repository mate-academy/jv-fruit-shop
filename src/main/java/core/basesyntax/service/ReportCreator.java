package core.basesyntax.service;

import core.basesyntax.db.ProductStorage;
import java.util.List;

public interface ReportCreator {
    List<String> create(ProductStorage storage);
}
