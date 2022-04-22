package core.basesyntax.utils;

import java.util.List;
import java.util.Map;

public interface ParserData {
    Map<String, Integer> parsedWithFile(List<String> data);
}
