package core.basesyntax.services;

import core.basesyntax.Record;
import core.basesyntax.RecordType;
import core.basesyntax.Storage;
import core.basesyntax.operations.ExpendShopOperation;
import core.basesyntax.operations.IncomeShopOperation;
import core.basesyntax.operations.ShopOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductCalculatorService {
    private Storage storage;
    private Map<RecordType, ShopOperation> dealMap = new HashMap<>();

    public ProductCalculatorService(Storage storage) {
        this.storage = storage;
        initDealMap();
    }

    private void initDealMap() {
        dealMap.put(RecordType.s, new IncomeShopOperation(storage));
        dealMap.put(RecordType.r, new IncomeShopOperation(storage));
        dealMap.put(RecordType.b, new ExpendShopOperation(storage));
    }

    public void calculateBalance(List<Record> recordList) {
        for (Record record : recordList) {
            ShopOperation operation = dealMap.get(record.getType());
            operation.transaction(record);
        }
    }
}
