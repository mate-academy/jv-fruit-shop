package core.basesyntax.model;

public class Record {
    private final String transactionAbbr;
    private final String fruitName;
    private final int amount;

    public Record(String transactionAbbr, String fruitName, int amount) {
        this.transactionAbbr = transactionAbbr;
        this.fruitName = fruitName;
        this.amount = amount;
    }

    public String getTransactionAbbr() {
        return transactionAbbr;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getAmount() {
        return amount;
    }
}
