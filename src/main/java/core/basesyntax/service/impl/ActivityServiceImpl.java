package core.basesyntax.service.impl;

import core.basesyntax.strategy.Activity;
import core.basesyntax.strategy.Balance;
import core.basesyntax.strategy.Purchase;
import core.basesyntax.strategy.Return;
import core.basesyntax.strategy.Supply;


import java.util.HashMap;
import java.util.Map;

public class ActivityServiceImpl {
    public Map<Character, Activity> activityMap = new HashMap();

    public Activity getActivity(char activityLetter) {
        activityMap.put('b', new Balance());
        activityMap.put('p', new Purchase());
        activityMap.put('r', new Return());
        activityMap.put('s', new Supply());
        return activityMap.get(activityLetter);
    }
}
