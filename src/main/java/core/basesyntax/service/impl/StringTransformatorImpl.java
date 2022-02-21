package core.basesyntax.service.impl;

import core.basesyntax.service.StringTransformator;
import java.util.List;
import java.util.stream.Collectors;

public class StringTransformatorImpl implements StringTransformator {
    @Override
    public List<String[]> transformString(List<String> list) {
        return list.stream()
                .map(l -> l.split(","))
                .collect(Collectors.toList());
    }
}
