package core.basesyntax.service;

import core.basesyntax.model.*;
import java.util.*;

public interface DataHandlerService {
    Map<String, Integer> handleData(List<FruitRecord> fruitRecords);
}
