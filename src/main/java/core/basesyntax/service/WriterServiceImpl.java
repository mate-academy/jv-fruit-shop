package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WriterServiceImpl implements WriterService{
    @Override
    public List<String> writeToFile() {
       return Storage.fruits.entrySet()
                .stream()
                .map(this::getFromMap)
                .collect(Collectors.toList());
    }

    private String getFromMap(Map.Entry<Fruit,Integer> set){
        String fruit = set.getKey().toString().toLowerCase();
        String quantity = set.getValue().toString();
        return fruit + ", " + quantity + System.lineSeparator();
    }
}
