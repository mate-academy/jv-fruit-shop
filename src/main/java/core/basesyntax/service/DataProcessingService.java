package core.basesyntax.service;

import core.basesyntax.model.Activity;
import java.util.List;
import java.util.Map;

public interface DataProcessingService {
    Map<String, Integer> processTheData(List<Activity> activities);
}
