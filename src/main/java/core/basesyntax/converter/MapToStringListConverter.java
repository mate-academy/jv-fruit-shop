package core.basesyntax.converter;

import java.util.List;
import java.util.Map;

public interface MapToStringListConverter {
    List<String> parseMap(Map<String, Integer> map);
}
