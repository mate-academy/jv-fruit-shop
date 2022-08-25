package core.basesyntax.service;

import core.basesyntax.model.TypeActivity;
import java.util.Map;

public class DecodeStrategyImpl implements DecodeStrategy {
    private final Map<String, TypeActivity> map;

    public DecodeStrategyImpl(Map<String, TypeActivity> map) {
        this.map = map;
    }

    @Override
    public TypeActivity get(String shortForm) {
        return map.get(shortForm);
    }
}
