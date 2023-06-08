package fruit.shop.strategy;

public class ActivityStrategyImpl implements ActivityStrategy {
    @Override
    public int handleTransaction(String strOption, int currentValue, int value) {
        OptionRepresentation option = OptionRepresentation.getOptionRepresentation(strOption);
        switch (option) {
            case BALANCE:
                return new BalanceHandler().getOptionResult(currentValue, value);
            case SUPPLY:
                return new SupplyHandler().getOptionResult(currentValue, value);
            case PURCHASE:
                return new PurchaseHandler().getOptionResult(currentValue, value);
            case RETURN:
                return new ReturnHandler().getOptionResult(currentValue, value);
            default:
                throw new RuntimeException("There is no such strOption!");
        }
    }

    private enum OptionRepresentation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String stringOption;

        OptionRepresentation(String stringOption) {
            this.stringOption = stringOption;
        }

        private static OptionRepresentation getOptionRepresentation(String option) {
            for (OptionRepresentation optionRepresentation : OptionRepresentation.values()) {
                if (optionRepresentation.stringOption.equals(option)) {
                    return optionRepresentation;
                }
            }
            throw new RuntimeException("There is no such option!");
        }
    }

}

