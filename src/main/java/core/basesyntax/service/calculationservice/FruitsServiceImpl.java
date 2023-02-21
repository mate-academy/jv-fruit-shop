package core.basesyntax.service.calculationservice;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.entity.FruitTransaction;
import core.basesyntax.service.handlerservice.HandlerService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitsServiceImpl implements FruitService {
    private FruitsDao fruitsDao;
    private HandlerService realizeByActivityFruits;

    public FruitsServiceImpl(FruitsDao fruitsDao, HandlerService realizeByActivityFruits) {
        this.fruitsDao = fruitsDao;
        this.realizeByActivityFruits = realizeByActivityFruits;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {

        Map<String, List<FruitTransaction>> map = mapFruits(transactions);
        for (Map.Entry<String, List<FruitTransaction>> fruit : map.entrySet()) {
            Integer result = 0;
            for (int i = 0; i < fruit.getValue().size(); i++) {
                result = Integer.sum(result, realizeByActivityFruits
                        .getHandler(fruit.getValue().get(i).getOperation())
                        .handle(fruit.getValue().get(i).getQuantity()));
            }
            fruitsDao.addFruit(fruit.getKey(), result);
        }
    }

    private Map<String, List<FruitTransaction>> mapFruits(List<FruitTransaction> str) {
        return str.stream()
                .collect(Collectors.groupingBy(FruitTransaction::getFruit));
    }
}
