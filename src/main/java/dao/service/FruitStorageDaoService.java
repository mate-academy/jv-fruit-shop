package dao.service;

import java.time.LocalDate;
import java.util.Map;

public interface FruitStorageDaoService {
    boolean add(Map<String, Integer> validMap);

    Map<String, Integer> get(LocalDate date);
}
