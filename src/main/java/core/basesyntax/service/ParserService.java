package core.basesyntax.service;

import core.basesyntax.model.Activity;
import core.basesyntax.strategy.Strategy;
import java.util.List;
import java.util.Map;

public interface ParserService {
    List<Activity> parse(List<String> list, Map<String, Strategy> operationStrategies);
}
