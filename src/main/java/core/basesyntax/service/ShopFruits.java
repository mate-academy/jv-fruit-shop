package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopFruits implements Shop<FruitTransaction> {
    private static final StringBuilder TITLE_FOR_RESULT = new StringBuilder("fruit,quantity");
    private static final String NEW_LINE = System.lineSeparator();
    private static final String BANANA = "banana";
    private static final String APPLE = "apple";
    private static final String PUNCTUATION_MARK = ",";
    private final Map<String, Integer> reportMap;

    public ShopFruits() {
        reportMap = new HashMap<>();
    }

    @Override
    public void processTransactions(List<? extends FruitTransaction> transactions) {
        if (transactions.size() == 0) {
            throw new RuntimeException("CSV file is empty!");
        } else {
            for (FruitTransaction transaction: transactions) {
                processTransaction(transaction);
            }
        }
    }

    @Override
    public String getReportData() {
        return TITLE_FOR_RESULT.append(NEW_LINE)
                .append(BANANA)
                .append(PUNCTUATION_MARK)
                .append(reportMap.get(BANANA))
                .append(NEW_LINE)
                .append(APPLE)
                .append(PUNCTUATION_MARK)
                .append(reportMap.get(APPLE)).toString();
    }

    public void processTransaction(FruitTransaction transaction) {
        switch (transaction.getOperation()) {
            case BALANCE:
                setBalance(transaction.getFruit(), transaction.getQuantity());
                break;
            case SUPPLY:
                operationSupply(transaction.getFruit(), transaction.getQuantity());
                break;
            case PURCHASE:
                operationPurchase(transaction.getFruit(), transaction.getQuantity());
                break;
            default:
                operationReturn(transaction.getFruit(), transaction.getQuantity());
        }
    }

    private void setBalance(String fruit, int quantity) {
        reportMap.put(fruit, quantity);
    }

    private void operationSupply(String fruit, int quantity) {
        Integer supply = reportMap.get(fruit) + quantity;
        reportMap.put(fruit, supply);
    }

    private void operationPurchase(String fruit, int quantity) {
        Integer purchase = reportMap.get(fruit) - quantity;
        reportMap.put(fruit, purchase);
    }

    private void operationReturn(String fruit, int quantity) {
        Integer returned = reportMap.get(fruit) + quantity;
        reportMap.put(fruit, returned);
    }
}

