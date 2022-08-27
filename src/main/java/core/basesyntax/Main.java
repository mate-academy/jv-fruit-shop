package core.basesyntax;

import core.basesyntax.service.TransactionService;
import core.basesyntax.service.TransactionServiceImpl;

public class Main {
    public static void main(String[] args) {
        TransactionService transactionService = new TransactionServiceImpl();
        transactionService.moveDataFromFileToDb("data2508202.csv");
        transactionService.createReport("report.csv");
    }
}
