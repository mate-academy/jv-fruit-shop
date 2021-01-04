package core.basesyntax.service;

import core.basesyntax.model.AbstractOperation;
import core.basesyntax.model.Operation;
import core.basesyntax.model.OperationFactory;
import core.basesyntax.model.OperationSet;
import core.basesyntax.model.entities.Fruit;
import core.basesyntax.model.entities.Product;
import core.basesyntax.service.io.DataImporter;
import core.basesyntax.service.io.ReportWriter;

import java.util.List;

public class FruitService extends AbstractService<Fruit> {

    public FruitService(DataImporter<Fruit> importer, ReportWriter<Fruit> reportWriter) {
        super(importer, reportWriter);
    }

    public void importData() {
        List<String[]> data = importer.importData();
        OperationFactory<Fruit> operationFactory = new OperationFactory<>(warehouse);
        Validator<Fruit> validator = new Validator<>(warehouse);
        for (String[] row : data) {
            AbstractOperation<Fruit> operation = operationFactory.get(OperationSet.valueOf(row[0].toUpperCase()));
            Product fruit = new Fruit(row[1]);
            Integer amount = Integer.valueOf(row[2]);
            validator.validateOperation(operation, fruit, amount);
        }
    }

    public void writeReport() {
        reportWriter.writeReport(warehouse);
    }
}
