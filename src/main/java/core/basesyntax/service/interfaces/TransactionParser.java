package core.basesyntax.service.interfaces;

public interface TransactionParser<T, K> {
    T parse(K data);
}
