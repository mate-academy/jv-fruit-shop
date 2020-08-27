package core.basesyntax;

import core.basesyntax.model.FruitDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

public class Storage {
    private Map<String, Map<LocalDate, Integer>> fruitsStorage;

    public Storage() {
        fruitsStorage = new HashMap<>();
    }

    public Map<String, Map<LocalDate, Integer>> getFruitsStorage() {
        return fruitsStorage;
    }

    public void addItemData(FruitDto fruitDto) {
        Map<LocalDate, Integer> map;
        if (fruitsStorage.isEmpty() || (map = fruitsStorage.get(fruitDto.getName())) == null) {
            fruitsStorage.put(fruitDto.getName(),
                    Map.of(fruitDto.getDate(), fruitDto.getQuantity()));
            return;
        }
        Map<LocalDate, Integer> newMap = new HashMap<>(map);
        if (map.containsKey(fruitDto.getDate())) {
            newMap.put(fruitDto.getDate(), map.get(fruitDto.getDate()) + fruitDto.getQuantity());
        } else {
            newMap.put(fruitDto.getDate(), fruitDto.getQuantity());
        }
        fruitsStorage.put(fruitDto.getName(), newMap);
    }

    public void removeItemData(FruitDto fruitDto) {
        Map<LocalDate, Integer> map;
        int currentQuantity = 0;
        if (fruitsStorage.isEmpty() || (map = fruitsStorage.get(fruitDto.getName())) == null) {
            throw new NoSuchElementException("Can't remove data from storage!!!");
        }
        Map<LocalDate, Integer> returnedMap = new HashMap<>(map);
        Set<LocalDate> localDates = new TreeSet<>(returnedMap.keySet());
        for (LocalDate date : localDates) {
            if (fruitDto.getDate().isBefore(date)) {
                if ((currentQuantity += map.get(date)) >= fruitDto.getQuantity()) {
                    returnedMap.put(date, currentQuantity - fruitDto.getQuantity());
                    fruitsStorage.put(fruitDto.getName(), returnedMap);
                    break;
                }
            }
            returnedMap.remove(date);
        }
        fruitsStorage.put(fruitDto.getName(), returnedMap);
        if (returnedMap.isEmpty()) {
            throw new NoSuchElementException(fruitDto.getName() + " are spoiled!!!");
        }
    }

    public List<String> getListInfo() {
        if (fruitsStorage.isEmpty()) {
            throw new NoSuchElementException("Can't get info, storage is empty!!!");
        }
        List<String> resultList = new ArrayList<>();
        resultList.add("fruit,quantity");
        for (Map.Entry<String, Map<LocalDate, Integer>> entry : fruitsStorage.entrySet()) {
            Integer reduce = entry.getValue().values().stream().reduce(0, (x, y) -> x + y);
            resultList.add(String.format("%s,%d", entry.getKey(), reduce));
        }
        return resultList;
    }
}
