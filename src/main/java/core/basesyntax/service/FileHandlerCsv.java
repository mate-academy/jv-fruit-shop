package core.basesyntax.service;

import core.basesyntax.serviceimpl.FruitTransaction;
import java.util.List;

public interface FileHandlerCsv {
    List<FruitTransaction> parse(List<String> info);
}
