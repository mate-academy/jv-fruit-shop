package core.basesyntax.processdata;

import java.util.List;
import java.util.Map;

public interface ProcessData {
    Map<String, Integer> process(List<List<String>> data);
}
