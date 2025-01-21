package core.basesyntax.models.activities;

public class ReturnActivityHandler implements ActivityHandler {

    @Override
    public Integer apply(Integer integer, Integer integer2) {
        return Integer.sum(integer, integer2);
    }
}
