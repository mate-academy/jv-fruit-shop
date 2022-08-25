package core.basesyntax;

import core.basesyntax.service.TransactionService;

public class Main {
    public static void main(String[] args) {
        TransactionService transactionService = new TransactionService();
        transactionService.createReport();
    }
}
