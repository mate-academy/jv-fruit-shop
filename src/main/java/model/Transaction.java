package model;

import strategy.OperationBalance;
import strategy.OperationPurchase;
import strategy.OperationReturn;
import strategy.OperationStrategy;
import strategy.OperationSupply;

public interface Transaction {
    OperationStrategy getOperationStrategy();

    String getItemName();

    int getQuantity();

    public enum Operation {
        BALANCE("b") {
            @Override
            OperationStrategy getOperationStrategy(Transaction fruitTransaction) {
                return new OperationBalance(fruitTransaction);
            }
        },
        SUPPLY("s") {
            @Override
            OperationStrategy getOperationStrategy(Transaction fruitTransaction) {
                return new OperationSupply(fruitTransaction);
            }
        },
        PURCHASE("p") {
            @Override
            OperationStrategy getOperationStrategy(Transaction fruitTransaction) {
                return new OperationPurchase(fruitTransaction);
            }
        },
        RETURN("r") {
            @Override
            OperationStrategy getOperationStrategy(Transaction fruitTransaction) {
                return new OperationReturn(fruitTransaction);
            }
        };

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        abstract OperationStrategy getOperationStrategy(Transaction fruitTransaction);
    }
}
