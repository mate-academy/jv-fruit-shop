package model;

import services.FruitDaoService;
import services.OperationsHandler;

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

    public Set<Fruit> doAllOperation(List<FruitRecord> recordList, FruitDaoService storage) {
        recordList
                .forEach(e -> typesOfOperations.get(e.getTypeOfOperation()).apply(storage, e));
        return storage.getAll();
    }
}
