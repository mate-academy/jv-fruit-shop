package service.impl;

import dao.ActionDao;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.FruitService;
import strategy.OperationStrategy;

public class FruitServiceImpl implements FruitService {
    private final ActionDao actionDao;
    private final OperationStrategy operationStrategy;

    public FruitServiceImpl(ActionDao actionDao, OperationStrategy operationStrategy) {
        this.actionDao = actionDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> createReport() {
        return actionDao.getListTransactions().stream()
                .collect(Collectors.groupingBy(FruitTransaction::getFruit,
                        Collectors.summingInt(act -> operationStrategy.get(act.getOperation())
                                .getAmount(act.getQuantity()))));
    }
}
