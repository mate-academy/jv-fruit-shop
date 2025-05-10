package core.basesyntax.service.interfaces;

import java.util.List;

public interface TransactionParser<T> {
    List<T> parse(List<String> rawString);
}
