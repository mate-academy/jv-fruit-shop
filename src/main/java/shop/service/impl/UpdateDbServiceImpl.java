package shop.service.impl;

import java.util.HashMap;
import java.util.List;
import shop.service.UpdateDbService;
import shop.service.action.ActionHandler;
import shop.service.action.ActionStrategyHandler;

public class UpdateDbServiceImpl implements UpdateDbService {
    private static final int ACTION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int COUNT_INDEX = 2;
    private final ActionStrategyHandler actionStrategy;

    public UpdateDbServiceImpl(HashMap<String, ActionHandler> actionMap) {
        actionStrategy = new ActionStrategyHandlerImpl(actionMap);
    }

    @Override
    public boolean updateStorage(List<String> listInput) {
        listInput.stream().map(list -> list.split(","))
                .forEach(line -> actionStrategy.get(line[ACTION_INDEX])
                        .update(line[FRUIT_NAME_INDEX],
                                Integer.parseInt(line[COUNT_INDEX])));
        return true;
    }
}
