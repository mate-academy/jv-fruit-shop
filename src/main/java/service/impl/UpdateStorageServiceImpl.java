package service.impl;

import java.util.HashMap;
import java.util.List;
import model.Operation;
import service.ParserService;
import service.UpdateStorageService;
import service.action.ActionStrategyHandler;
import service.strategy.ActionStrategy;
import service.strategy.ActionStrategyImpl;

public class UpdateStorageServiceImpl implements UpdateStorageService {
    private static final int INDEX_OF_ACTION = 0;
    private static final int INDEX_OF_NAME = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private final ActionStrategy actionStrategy;
    private final ParserService parserService;

    public UpdateStorageServiceImpl(HashMap<Operation,
            ActionStrategyHandler> actionStrategyHashMap) {
        parserService = new ParserServiceImpl();
        actionStrategy = new ActionStrategyImpl(actionStrategyHashMap);
    }

    @Override
    public boolean updateStorageData(List<String> listInput) {
        for (String data : listInput) {
            String[] dataArray = parserService.parser(data);
            ActionStrategyHandler action = actionStrategy.get(dataArray[INDEX_OF_ACTION]);
            action.doing(dataArray[INDEX_OF_NAME], Integer.parseInt(dataArray[INDEX_OF_QUANTITY]));
        }
        return true;
    }
}
