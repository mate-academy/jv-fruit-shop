package core.basesyntax.shop;

import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;

public class Shop {
    private Storage storage;
    private Map<String, Trading> tradings;

    public Shop(Map<String, Trading> tradings, Storage storage) {
        this.tradings = tradings;
        this.storage = storage;
    }

    public void trade(String type, Fruit fruit) {
        Trading trading = tradings.get(type);
        if (trading == null) {
            throw new NullPointerException("Passed parameter is null");
        }
        trading.trade(fruit);
    }

    public List<Fruit> balanceStorage() {
        return storage.getAll();
    }
}
