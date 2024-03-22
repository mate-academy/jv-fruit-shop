package core.basesyntax.service;

import core.basesyntax.model.FruitsTransaction;
import java.util.List;

public interface DataParserService {
    List<FruitsTransaction> parse(List<String> data);
}
