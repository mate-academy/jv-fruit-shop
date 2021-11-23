package shop.service.impl;

import java.util.HashMap;
import java.util.List;
import shop.service.UpdateDbService;
import shop.service.action.ActionHandler;
import shop.service.action.ActionStrategyHandlers;

public class UpdateDbServiceImpl implements UpdateDbService {
    private static final String SEPARATOR = ",";
    private static final int ACTION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int COUNT_INDEX = 2;
    private final ActionStrategyHandlers actionStrategy;

    public UpdateDbServiceImpl(HashMap<String, ActionHandler> actionMap) {
        actionStrategy = new ActionStrategyHandlersImpl(actionMap);
    }

    @Override
    public void updateStorage(List<String> listInput) {
        for (String data : listInput) {
            String[] dataArray = data.split(SEPARATOR);
            ActionHandler action = actionStrategy.get(dataArray[ACTION_INDEX]);
            action.update(dataArray[FRUIT_NAME_INDEX], Integer.parseInt(dataArray[COUNT_INDEX]));
        }
    }
}
