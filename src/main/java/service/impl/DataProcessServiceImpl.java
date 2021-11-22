package service.impl;

import java.util.List;
import service.DataProcessService;
import service.action.ActionStrategyHandler;
import service.strategy.ActionStrategyImpl;

public class DataProcessServiceImpl implements DataProcessService {
    private static final ActionStrategyImpl ACTION_STRATEGY = new ActionStrategyImpl();
    private static final int INDEX_OF_ACTION = 0;
    private static final int INDEX_OF_NAME = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public boolean dataProcessing(List<String> listInput) {
        for (String data : listInput) {
            String[] dataArray = data.split(",");
            ActionStrategyHandler action = ACTION_STRATEGY.get(dataArray[INDEX_OF_ACTION]);
            action.doing(dataArray[INDEX_OF_NAME], Integer.parseInt(dataArray[INDEX_OF_QUANTITY]));
        }
        return true;
    }
}
