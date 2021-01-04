package core.basesyntax.service;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.entities.Product;
import core.basesyntax.service.io.DataImporter;
import core.basesyntax.service.io.ReportWriter;

public abstract class AbstractService<T extends Product> {
    protected final DataImporter<T> importer;
    protected final ReportWriter<T> reportWriter;
    protected final Warehouse<T> warehouse;

    public AbstractService(DataImporter<T> importer, ReportWriter<T> reportWriter) {
        this.importer = importer;
        this.reportWriter = reportWriter;
        warehouse = new Warehouse<>();
    }

    public Warehouse<T> getWarehouse() {
        return warehouse;
    }

}
