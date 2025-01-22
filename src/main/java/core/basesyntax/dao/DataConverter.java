package core.basesyntax.dao;

import core.basesyntax.models.Fruit;
import java.util.List;

public interface DataConverter {
    List<Fruit> convertToTransaction(List<String> productsInString);
}
