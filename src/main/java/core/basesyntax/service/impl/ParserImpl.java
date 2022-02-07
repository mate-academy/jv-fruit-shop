package core.basesyntax.service.impl;

import core.basesyntax.model.DailyActivity;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    @Override
    public List<DailyActivity> parse(List<String> list) {

        List<DailyActivity> dailyActivities = new ArrayList<>();
        list.remove(0);
        for (String transaction : list) {
            new ValidatorImpl().validate(transaction.trim());
            String [] splitData = transaction.split(",");
            dailyActivities.add(new DailyActivity(Integer.parseInt(splitData[2]),
                    splitData[0], splitData[1]));
        }
        return dailyActivities;
    }
}
