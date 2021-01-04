package core.basesyntax.service.io;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.entities.Product;

public interface ReportWriter<T extends Product> {
    void writeReport(Warehouse<T> warehouse);
}
