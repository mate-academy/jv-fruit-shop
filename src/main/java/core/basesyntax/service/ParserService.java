package core.basesyntax.service;

import core.basesyntax.dto.Transaction;
import java.util.List;

public interface ParserService {
    List<Transaction> parse(List<String> list);
}
