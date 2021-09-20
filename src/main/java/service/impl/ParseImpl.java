package service.impl;

import service.OperationStrategy;
import service.Parse;
import service.operation.Handler;

import java.util.List;

public class ParseImpl implements Parse {
    OperationStrategy strategy = new OperationStrategyImpl();
    @Override
    public void parseList(List<String> list) {
        for (int i = 1; i < list.size(); i++) {
            String[] split = list.get(i).split(",");
            Handler handler = strategy.get(split);
            handler.calc(split[1], Integer.parseInt(split[2]));
        }
    }
}
