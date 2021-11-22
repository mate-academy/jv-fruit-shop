package service;

import java.util.List;
import service.action.type.ActionStrategyHandler;

public class DataProcessingServiceImpl implements DataProcessingService {
    private final ActionStrategyImpl actionStrategy = new ActionStrategyImpl();

    @Override
    public void dataProcessing(List<String> listInput) {
        for (String data : listInput) {
            String[] dataArray = data.split(",");
            ActionStrategyHandler action = actionStrategy.get(dataArray[0]);
            action.doing(dataArray);
        }
    }
}
