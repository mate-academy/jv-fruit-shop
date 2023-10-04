package core.basesyntax.model;

public interface TransactionParser {
    FruitTransaction[] parseTransaction(String[] csvLines);
}
