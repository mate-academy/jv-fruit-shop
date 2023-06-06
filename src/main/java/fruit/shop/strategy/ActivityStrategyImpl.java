package fruit.shop.strategy;

public class ActivityStrategyImpl implements ActivityStrategy {
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";

    @Override
    public int setValueAccordingToOption(String option, int currentValue, int value) {
        switch (option) {
            case BALANCE:
                return new BalanceOption().getOptionResult(currentValue, value);
            case SUPPLY:
                return new SupplyOption().getOptionResult(currentValue, value);
            case PURCHASE:
                return new PurchaseOption().getOptionResult(currentValue, value);
            case RETURN:
                return new ReturnOption().getOptionResult(currentValue, value);
            default:
                throw new RuntimeException("There is no such option!");
        }
    }
}
