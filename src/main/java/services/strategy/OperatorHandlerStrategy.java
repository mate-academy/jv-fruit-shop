package services.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import model.Fruit;
import model.FruitRecord;
import services.FruitDaoService;

public class OperatorHandlerStrategy {
    private Map<Character, OperationsHandler> typesOfOperations = new HashMap();

    public Map<Character, OperationsHandler> getTypesOfOperations() {
        return typesOfOperations;
    }

    public void setTypesOfOperations(Map<Character, OperationsHandler> typesOfOperations) {
        this.typesOfOperations = typesOfOperations;
    }

    public Set<Fruit> doAllOperation(List<FruitRecord> recordList, FruitDaoService storage) {
        recordList
                .forEach(e -> typesOfOperations.get(e.getTypeOfOperation()).apply(storage, e));
        return storage.get();
    }
}
