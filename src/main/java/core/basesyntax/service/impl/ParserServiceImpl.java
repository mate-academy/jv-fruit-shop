package core.basesyntax.service.impl;

import core.basesyntax.model.Activity;
import core.basesyntax.service.ParserService;
import core.basesyntax.strategy.Strategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParserServiceImpl implements ParserService {
    @Override
    public List<Activity> parse(List<String> list, Map<String, Strategy> operationStrategies) {
        List<Activity> activities = new ArrayList<>();
        for (String element : list) {
            activities.add(
                    new Activity(
                            operationStrategies.get(element.split(",")[0]),
                            element.split(",")[1],
                            Integer.parseInt(element.split(",")[2]))
            );
        }
        return activities;
    }
}
