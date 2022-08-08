package core.basesyntax.service.data;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class DataServiceCsv implements DataService<String> {
    @Override
    public void processData(List<String> list, Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        new FruitDaoImpl().clear();
        list.stream()
                .map(s -> new CsvParserImpl().parser(s))
                .forEach(o -> operationHandlerMap
                        .get(o.getOperation()).handle(o.getFruit(), o.getQuantity()));
    }
}
