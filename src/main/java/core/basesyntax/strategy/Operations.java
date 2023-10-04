package core.basesyntax.strategy;

import core.basesyntax.strategy.impl.BalanceOperationHandlerImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandlerImpl;
import core.basesyntax.strategy.impl.ReturnOperationHandlerImpl;
import core.basesyntax.strategy.impl.SupplyOperationHandlerImpl;

public enum Operations {
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
