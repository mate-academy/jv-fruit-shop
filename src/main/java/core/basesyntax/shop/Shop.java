package core.basesyntax.shop;

import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Shop {
    private Storage storage = new Storage();
    private Map<String, Trading> tradings;

    public Shop(Map<String, Trading> trading) {
        this.tradings = trading;
    }

    public void trade(String type, Fruit fruit) {
        Trading trading = tradings.get(type);
        if (trading == null) {
            throw new NullPointerException();
        }
        trading.trade(storage, fruit);
    }

    public List<String> balanceStorage() {
        return storage.getAll()
                .stream()
                .map(Fruit::toString)
                .collect(Collectors.toList());
    }
}
