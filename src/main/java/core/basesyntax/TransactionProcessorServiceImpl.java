package core.basesyntax;

import java.util.List;

public class TransactionProcessorServiceImpl implements ProcessorService {
    @Override
    public void processTransactions(List<FruitTransaction> transactions, FruitStorage storage) {
        for (FruitTransaction transaction : transactions) {
            switch (transaction.getOperation()) {
                case BALANCE:
                    processBalanceTransaction(transaction, storage);
                    break;
                case SUPPLY:
                    processSupplyTransaction(transaction, storage);
                    break;
                case PURCHASE:
                    processPurchaseTransaction(transaction, storage);
                    break;
                case RETURN:
                    processReturnTransaction(transaction, storage);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid transaction type: " + transaction.getOperation());
            }
        }
    }

    private void processBalanceTransaction(FruitTransaction transaction, FruitStorage storage) {
        storage.updateQuantity(transaction.getFruit(), transaction.getQuantity());
    }

    private void processSupplyTransaction(FruitTransaction transaction, FruitStorage storage) {
        storage.updateQuantity(transaction.getFruit(), transaction.getQuantity());
    }

    private void processPurchaseTransaction(FruitTransaction transaction, FruitStorage storage) {
        int availableQuantity = storage.getFruitQuantities().getOrDefault(transaction.getFruit(), 0);
        if (availableQuantity >= transaction.getQuantity()) {
            storage.updateQuantity(transaction.getFruit(), -transaction.getQuantity());
        } else {
            throw new RuntimeException("Not enough quantity of " + transaction.getFruit() + " for purchase");
        }
    }

    private void processReturnTransaction(FruitTransaction transaction, FruitStorage storage) {
        storage.updateQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}

