package core.basesyntax.service;

import core.basesyntax.model.FruitsTransaction;

import java.util.List;

public interface DataParseService {
    List<FruitsTransaction> getTransactionList(List<String> data);
}
