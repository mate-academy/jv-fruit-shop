package core.basesyntax.strategy;

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
