package core.basesyntax.service.parser;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface ParserService {
    List<Transaction> parse(List<String> dataFromFile);
}
