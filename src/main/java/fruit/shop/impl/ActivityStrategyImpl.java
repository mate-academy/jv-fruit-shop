package fruit.shop.impl;

import fruit.shop.service.strategy.*;

public class ActivityStrategyImpl implements ActivityStrategy {
    @Override
    public int handleTransaction(String strOption, int currentValue, int value) {
        Operation option = Operation.getOptionRepresentation(strOption);
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
    private enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String stringOption;

        Operation(String stringOption) {
            this.stringOption = stringOption;
        }

        private static Operation getOptionRepresentation(String option) {
            for (Operation operation : Operation.values()) {
                if (operation.stringOption.equals(option)) {
                    return operation;
                }
            }
            throw new RuntimeException("There is no such option!");
        }
    }

}

