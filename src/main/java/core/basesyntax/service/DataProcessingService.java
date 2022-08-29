package core.basesyntax.service;

import java.util.List;
import java.util.Map;
import core.basesyntax.model.Activity;

public interface DataProcessingService {
    Map<String, Integer> processTheData(List<Activity> activities);
}
