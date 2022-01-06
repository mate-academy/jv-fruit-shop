package core.basesyntax.service;

import core.basesyntax.service.activities.StorageService;
import java.util.List;
import java.util.Map;

public class ActivitiesServiceImpl implements ActivitiesService {
    @Override
    public void doingOperations(List<String> fromFile, Map<String, StorageService> storageMap) {
        fromFile.remove(0);
        for (String s : fromFile) {
            List<String> listOfFruits = List.of(s.split(","));
            storageMap.get(listOfFruits.get(0))
                    .apply(listOfFruits.get(1), Integer.parseInt(listOfFruits.get(2)));
        }
    }
}
