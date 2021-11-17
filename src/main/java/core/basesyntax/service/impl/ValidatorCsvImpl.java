package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;
import core.basesyntax.service.activitiy.ActivityHandler;
import core.basesyntax.service.activitiy.ActivityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidatorCsvImpl implements Validator {
    private Map<ActivityType, ActivityHandler> activityHandlerMap;

    public ValidatorCsvImpl(Map<ActivityType, ActivityHandler> activityHandlerMap) {
        this.activityHandlerMap = activityHandlerMap;
    }

    public boolean validate(List<String> fileData) {
        if (!fileData.get(0).equals("type,fruit,quantity")) {
            return false;
        }
        List<String> dataCopy = new ArrayList<>(fileData);
        dataCopy.remove(0);
        Predicate<String> csvStringPredicate = s -> Pattern.matches("[bsrp],[a-z]+,[0-9]+", s)
                && activityHandlerMap
                .containsKey(ActivityType.valueOf(String.valueOf(s.charAt(0))))
                && s.charAt(s.lastIndexOf(',') + 1) != '0';
        List<String> collect = dataCopy.stream()
                .filter(csvStringPredicate)
                .collect(Collectors.toList());
        if (!(dataCopy.size() == collect.size())) {
            throw new RuntimeException("INPUT DATA IS INVALID");
        }
        return true;
    }
}
