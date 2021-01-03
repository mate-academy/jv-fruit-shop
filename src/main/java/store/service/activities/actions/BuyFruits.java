package store.service.activities.actions;

import java.util.function.BiFunction;

public class BuyFruits implements BiFunction<Integer, Integer, Integer> {
    @Override
    public Integer apply(Integer cosOfMap, Integer costOfList) {
        return cosOfMap - costOfList;
    }
}
