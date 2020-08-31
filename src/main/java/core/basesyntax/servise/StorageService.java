package core.basesyntax.servise;

import core.basesyntax.model.FruitDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

public class StorageService {
    private Map<String, Map<LocalDate, Integer>> fruitsStorage;

    public StorageService() {
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
        Integer integer = map.get(fruitDto.getDate()) == null ? 0 : map.get(fruitDto.getDate());
        newMap.put(fruitDto.getDate(), fruitDto.getQuantity() + integer);
        fruitsStorage.put(fruitDto.getName(), newMap);
    }

    public void removeItemData(FruitDto fruitDto) {
        Map<LocalDate, Integer> map;
        if (fruitsStorage.isEmpty() || (map = fruitsStorage.get(fruitDto.getName())) == null) {
            throw new NoSuchElementException("Can't remove data from storage!!!");
        }
        map = getEditedMap(map, fruitDto);
        if (map.isEmpty()) {
            fruitsStorage.remove(fruitDto.getName());
            throw new NoSuchElementException(fruitDto.getName() + " are spoiled!!!");
        }
        fruitsStorage.put(fruitDto.getName(), map);
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

    private Map<LocalDate, Integer> getEditedMap(Map<LocalDate, Integer> map, FruitDto fruitDto) {
        Map<LocalDate, Integer> returnedMap = new HashMap<>(map);
        Set<LocalDate> localDates = new TreeSet<>(returnedMap.keySet());
        int currentQuantity = 0;
        LocalDate currentDate = null;
        for (LocalDate date : localDates) {
            if (fruitDto.getDate().isBefore(date)) {
                if ((currentQuantity += map.get(date)) >= fruitDto.getQuantity()) {
                    returnedMap.put(date, currentQuantity - fruitDto.getQuantity());
                    currentQuantity = 0;
                    fruitsStorage.put(fruitDto.getName(), returnedMap);
                    break;
                }
                currentDate = date;
            }
            returnedMap.remove(date);
        }
        if (currentQuantity != 0) {
            returnedMap.put(currentDate, currentQuantity);
            fruitsStorage.put(fruitDto.getName(), returnedMap);
            throw new NoSuchElementException("Can get only " + currentQuantity + " "
                    + fruitDto.getName());
        }
        return returnedMap;
    }
}
