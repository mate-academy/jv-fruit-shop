package core.basesyntax.service.strategy.logic;

import core.basesyntax.service.strategy.BalanceStrategy;
import core.basesyntax.service.strategy.DefectiveStrategy;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.PurchaseStrategy;
import core.basesyntax.service.strategy.ReturnStrategy;
import core.basesyntax.service.strategy.SupplyStrategy;
import java.util.HashMap;
import java.util.Map;

public class StrategyMap {
    private static final Map<Operation, OperationStrategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put(Operation.BALANCE, new BalanceStrategy());
        strategyMap.put(Operation.SUPPLY, new SupplyStrategy());
        strategyMap.put(Operation.PURCHASE, new PurchaseStrategy());
        strategyMap.put(Operation.DEFECTIVE, new DefectiveStrategy());
        strategyMap.put(Operation.RETURN, new ReturnStrategy());
    }

    public static Map<Operation, OperationStrategy> getInstance() {
        return new HashMap<>(strategyMap);
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        DEFECTIVE("d"),
        RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation of(String letter) {
            for (Operation action : Operation.values()) {
                if (action.getCode().equalsIgnoreCase(letter)) {
                    return action;
                }
            }
            throw new IllegalArgumentException("No operation with letter " + letter + " in enum");
        }

        public String getCode() {
            return code;
        }
    }
}
