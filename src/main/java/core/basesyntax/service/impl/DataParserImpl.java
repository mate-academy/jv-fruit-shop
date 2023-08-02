package core.basesyntax.service.impl;

import core.basesyntax.model.Activity;
import core.basesyntax.service.DataParser;
import java.util.ArrayList;
import java.util.List;

public class DataParserImpl implements DataParser {

    @Override
    public List<Activity> processFile(List<String> listOflines) {
        listOflines.remove(0);
        List<Activity> listOfActivities = new ArrayList<>();
        for (String line : listOflines) {
            listOfActivities.add(new Activity(line));
        }
        return listOfActivities;
    }
}
