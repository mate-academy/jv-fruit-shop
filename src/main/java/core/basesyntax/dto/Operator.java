package core.basesyntax.dto;

import core.basesyntax.dao.DAoService;
import core.basesyntax.dto.handlers.OperationsHandler;
import core.basesyntax.models.Fruit;
import core.basesyntax.models.FruitRecord;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Operator {
    private Map<Character, OperationsHandler> typesOfOperations = new HashMap();

    public Map<Character, OperationsHandler> getTypesOfOperations() {
        return typesOfOperations;
    }

    public void setTypesOfOperations(Map<Character, OperationsHandler> typesOfOperations) {
        this.typesOfOperations = typesOfOperations;
    }

    public Set<Fruit> doAllOperation(List<FruitRecord> recordList, DAoService storage) {
        recordList
                .forEach(e -> typesOfOperations.get(e.getTypeOfOperation()).apply(storage, e));
        return storage.getWholeStorageCopy();
    }
}
