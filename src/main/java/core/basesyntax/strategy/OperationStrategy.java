package core.basesyntax.strategy;

import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandlerImpl;

public enum OperationStrategy {
    BALANCE {
        @Override
        public OperationHandler getHandler() {
            return new BalanceOperationHandlerImpl();
        }
    },
    PURCHASE {
        @Override
        public OperationHandler getHandler() {
            return new PurchaseOperationHandlerImpl();
        }
    },
    RETURN {
        @Override
        public OperationHandler getHandler() {
            return new ReturnOperationHandlerImpl();
        }
    },
    SUPPLY {
        @Override
        public OperationHandler getHandler() {
            return new SupplyOperationHandlerImpl();
        }
    };

    public abstract OperationHandler getHandler();
}
