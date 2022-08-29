package core.basesyntax.service;

import java.util.List;
import java.util.Map;
import core.basesyntax.model.Activity;
import core.basesyntax.strategy.Strategy;

public interface ParserService {
    List<Activity> parse(List<String> list, Map<String, Strategy> operationStrategies);
}
