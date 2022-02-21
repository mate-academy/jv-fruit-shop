package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitDto;
import java.util.List;

public interface FruitDao {
    void save(FruitDto fruit);

    Integer getValue(FruitDto fruit);

    List<Fruit> getAll();
}
