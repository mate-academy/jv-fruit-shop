package core.basesyntax.service.servicefructs;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.entity.FruitTransaction;
import core.basesyntax.service.strategyactivity.StrategySumByActivity;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceFruitsImpl implements ServiceFruits {
    private final FruitsDao fruitsStorageDao;
    private final StrategySumByActivity realizeByActivityFruits;

    public ServiceFruitsImpl(FruitsDao fruitsStorageDao,
                             StrategySumByActivity realizeByActivityFruits) {
        this.fruitsStorageDao = fruitsStorageDao;
        this.realizeByActivityFruits = realizeByActivityFruits;
    }

    @Override
    public String summaryOfTheDay(String nameFruit) {
        Map<String, BigDecimal> map = summaryByCategories(nameFruit);
        BigDecimal resultActivity = new BigDecimal(0);
        for (Map.Entry<String, BigDecimal> l : map.entrySet()) {
            resultActivity = resultActivity
                    .add(realizeByActivityFruits.getSumFruit(l.getKey())
                            .getSumFruits(l.getValue()));
        }
        return nameFruit + " " + resultActivity;
    }

    private Map<String, BigDecimal> summaryByCategories(String nameFruit) {
        BigDecimal bigDecimal = new BigDecimal(0);
        Map<String, BigDecimal> mapResult = new HashMap<>();
        Map<String, List<FruitTransaction>> mapFruits = fruitsStorageDao
                .getMapFruitByActivity(nameFruit);
        for (Map.Entry<String, List<FruitTransaction>> map : mapFruits.entrySet()) {
            for (int i = 0; i < map.getValue().size(); i++) {
                bigDecimal = bigDecimal.add(map.getValue().get(i).getQuantity());
            }
            mapResult.put(map.getKey(), bigDecimal);
            bigDecimal = new BigDecimal(0);
        }

        return mapResult;
    }
}
