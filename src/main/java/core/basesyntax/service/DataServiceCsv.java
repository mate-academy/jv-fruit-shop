package core.basesyntax.service;

import core.basesyntax.dao.DaoHashMap;
import core.basesyntax.operation.OperationHandlerMap;
import java.util.List;

public class DataServiceCsv implements DataService<String> {
    @Override
    public void processData(List<String> list) {
        new DaoHashMap().clear();
        list.stream()
                .map(s -> new ParserCsv().parser(s))
                .forEach(o -> OperationHandlerMap.operationHandlerMap
                        .get(o.getOperation()).performOperation(o.getFruit(), o.getQuantity()));
    }
}
