package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private ParseService parseService;
    private OperationHandlerService operationHandlerService;

    public FruitShopServiceImpl() {
        this.parseService = new ParseServiceImpl();
        this.operationHandlerService = new OperationHandlerServiceImpl();
    }

    @Override
    public void addInfoToStorage(List<String> rowsList) {
        ParseService parseService = new ParseServiceImpl();
        for (int i = 1; i < rowsList.size(); i++) {
            FruitRecord record = parseService.getParsedLine(rowsList.get(i));
            OperationHandlerService operationHandlerService = new OperationHandlerServiceImpl();
            operationHandlerService.changeAmount(record);
        }
    }
}
