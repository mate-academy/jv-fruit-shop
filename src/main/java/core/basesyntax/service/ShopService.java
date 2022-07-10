package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface ShopService {
    void processTheData(List<String[]> fileInfo);

    List<Fruit> getStatistic();

    String makeReport();
}
