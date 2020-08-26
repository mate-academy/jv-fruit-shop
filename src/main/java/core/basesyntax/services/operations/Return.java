package core.basesyntax.services.operations;

import java.util.Map;

public class Return implements Operable {

    @Override
    public boolean operate(Map<String, Map<String, Integer>> store, String[] data) {
        Supply supply = new Supply();
        return supply.operate(store, data);
    }
}
