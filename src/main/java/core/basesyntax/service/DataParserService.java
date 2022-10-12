package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface DataParserService {
    List<Transaction> parse(List<String> dataForParse);
}
