package core.basesyntax.service.activity;

public class SupplyActivityHandler implements ActivityHandler {
    @Override
    public Integer actionWithFruit(Integer amountOfFruit, Integer value) {
        return amountOfFruit + value;
    }
}
