package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParseService;
import java.util.List;
import java.util.ArrayList;

public class ParseServiceImpl implements ParseService {
    private static final int TYPE_OPERATION_INDEX = 0;
    private static final int GOODS_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<Transaction> parser(List<String> data) {
        List<Transaction> resultData = new ArrayList<>();
        data.stream().map(s -> s.split(SEPARATOR))
                .forEach(s -> resultData.add(new Transaction(Transaction.findOperationByName(s[TYPE_OPERATION_INDEX]),
                        s[GOODS_NAME_INDEX], Integer.parseInt(s[QUANTITY_INDEX]))));
        return resultData;
    }
}
