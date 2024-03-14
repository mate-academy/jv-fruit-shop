package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.record.Operation;
import core.basesyntax.record.Record;
import core.basesyntax.service.RecordMapper;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordMapper implements RecordMapper {
    @Override
    public List<Record> getRecordsFromLines(List<String> lines) {
        List<Record> records = new ArrayList<>();
        for (String line : lines) {
            String[] record = line.split(COMMA);
            Operation operation = Operation.getByCode(record[OPERATION_INDEX]);
            int quantity = Integer.parseInt(record[QUANTITY_INDEX]);
            if (quantity < 0) {
                throw new IllegalArgumentException("Quantity cannot be negative. Params=" + line);
            }
            Fruit fruit = new Fruit(record[PRODUCT_INDEX], quantity);
            records.add(new Record(operation, fruit));
        }
        return records;
    }
}
