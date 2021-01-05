package core.basesyntax.service;

import core.basesyntax.model.AbstractOperation;
import core.basesyntax.model.OperationFactory;
import core.basesyntax.model.OperationSet;
import core.basesyntax.model.entities.Fruit;
import core.basesyntax.service.io.ReportWriter;
import java.util.List;

public class FruitService extends AbstractService<Fruit> {

    public void importData(List<String[]> data) {
        OperationFactory<Fruit> operationFactory = new OperationFactory<>(warehouse);
        Validator<Fruit> validator = new Validator<>(warehouse);
        for (String[] row : data) {
            AbstractOperation<Fruit> operation =
                    operationFactory.get(OperationSet.valueOf(row[0].toUpperCase()));
            Fruit fruit = new Fruit(row[1]);
            Integer amount = Integer.valueOf(row[2]);
            validator.validateRecord(operation, fruit, amount);
            operation.execute(fruit, amount);
        }
    }

    public void writeReport(ReportWriter<Fruit> reportWriter) {
        reportWriter.writeReport(warehouse);
    }
}
