package core.basesyntax.services.operations;

import java.util.Map;

public class Return implements Operable {

    @Override
    public boolean updateStorage(Map<String, Map<String, Integer>> store, String[] data) {
        Supply supply = new Supply();
        return supply.updateStorage(store, data);
    }
}
