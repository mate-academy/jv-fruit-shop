package mate.academy.service;

import mate.academy.service.calculation.TransactionCalculation;

public interface TransactionStrategy {
    TransactionCalculation get(String operation);
}
