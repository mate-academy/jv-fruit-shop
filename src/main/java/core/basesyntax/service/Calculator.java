package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface Calculator {
    Map<String,Integer> calculate(List<String[]> notes);
}
