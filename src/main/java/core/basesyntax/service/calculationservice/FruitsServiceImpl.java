package core.basesyntax.service.calculationservice;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.entity.FruitTransaction;
import core.basesyntax.service.handlerservice.HandlerService;
import java.math.BigDecimal;
import java.util.List;

public class FruitsServiceImpl implements FruitService {
    private final FruitsDao fruitsStorageDao;
    private final HandlerService realizeByActivityFruits;

    public FruitsServiceImpl(FruitsDao fruitsStorageDao,
                             HandlerService realizeByActivityFruits) {
        this.fruitsStorageDao = fruitsStorageDao;
        this.realizeByActivityFruits = realizeByActivityFruits;
    }

    @Override
    public String calculationFruits(String nameFruit) {
        List<FruitTransaction> allListFruits = fruitsStorageDao.getAllListFruits(nameFruit);

        BigDecimal resultActivity = new BigDecimal(0);
        for (FruitTransaction fruits : allListFruits) {
            resultActivity = resultActivity
                    .add(realizeByActivityFruits
                            .getSumFruit(fruits.getActivity())
                            .handle(fruits.getQuantity()));
        }
        return nameFruit + " " + resultActivity;
    }
}
