package mate.academy.service;

import mate.academy.model.FruitTransaction;
import mate.academy.service.calculation.TransactionCalculation;

public interface TransactionStrategy {
    TransactionCalculation get(FruitTransaction.Operation operation);
}
