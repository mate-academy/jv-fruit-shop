package service;

import dao.FruitDao;
import java.util.Optional;
import service.interfaces.FruitOperationService;

public class FruitReturnServiceImpl implements FruitOperationService {
    private FruitDao fruitDao;

    public FruitReturnServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(TransactionDto dto) {
        Optional<Integer> currentQuantity = fruitDao.get(dto.getFruit());
        fruitDao.put(dto.getFruit(), currentQuantity.orElse(0)
                + dto.getQuantity());
    }
}
