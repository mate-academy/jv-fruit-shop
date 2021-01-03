package store.service.activities.actions;

import java.util.function.BiFunction;

public class ReturnFruits implements BiFunction<Integer, Integer, Integer> {
    @Override
    public Integer apply(Integer costOfList, Integer cosOfMap) {
        return cosOfMap + costOfList;
    }
}
