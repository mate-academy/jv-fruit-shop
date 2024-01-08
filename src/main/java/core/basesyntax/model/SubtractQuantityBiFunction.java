package core.basesyntax.model;

import java.util.function.BiFunction;

public class SubtractQuantityBiFunction implements BiFunction<Integer, Integer, Integer> {
    @Override
    public Integer apply(Integer oldQuantity, Integer newQuantity) {
        return oldQuantity - newQuantity;
    }
}
