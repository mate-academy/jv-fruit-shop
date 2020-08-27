package core.basesyntax.services.operations;

import java.util.Map;

public class Return implements Operable {
    private final Supply supply;

    public Return(Supply supply) {
        this.supply = supply;
    }

    @Override
    public boolean updateStorage(Map<String, Map<String, Integer>> store, String[] data) {

        return supply.updateStorage(store, data);
    }
}
