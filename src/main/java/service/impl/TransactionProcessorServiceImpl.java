package service.impl;

import dao.TransactionDao;
import db.Storage;
import model.FruitTransaction;
import service.TransactionProcessorService;
import strategy.OperationStrategy;

import java.util.List;
import java.util.Map;

public class TransactionProcessorServiceImpl implements TransactionProcessorService {
    Storage storage = new Storage();
//    private TransactionDao transactionDao;

    private final Map<FruitTransaction.Operation, OperationStrategy> strategies;

    public TransactionProcessorServiceImpl(Map<FruitTransaction.Operation, OperationStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public void processTransaction(List<FruitTransaction> listOfTransactions) {
        List<FruitTransaction> transactions = storage.getTransactions();
                int totalQuantity = listOfTransactions.stream()
                        .mapToInt(FruitTransaction::getQuantity) // Map to int instead of type
                        .sum();

        int purchaseQuantity = listOfTransactions.stream()
                .filter(tr -> "p".equals(tr.getType().getCode()))
                .mapToInt(FruitTransaction::getQuantity)
                .sum();

        int availableProduct = totalQuantity - purchaseQuantity;
                System.out.println("Available quantity is : " + availableProduct);
        }
    }
