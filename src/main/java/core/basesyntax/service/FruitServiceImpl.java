package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.strategy.FruitOperations;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.service.validation.Validator;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private Map<String, FruitOperations> operationsMap;
    private Validator validator;
    private FruitDao fruitDao;

    public FruitServiceImpl(Map<String, FruitOperations> operationsMap,
                            Validator validator, FruitDao fruitDao) {
        this.operationsMap = operationsMap;
        this.validator = validator;
        this.fruitDao = fruitDao;
    }

    @Override
    public void applyOperationsOnFruitsDto(List<FruitDto> transactions) {
        transactions.forEach(validator::validateFile);
        fruitDao.clearStorage();
        transactions.forEach(this::doFruitActivities);
    }

    private void doFruitActivities(FruitDto fruitDto) {
        operationsMap.get(fruitDto.getActivity()).doOperationWithFruit(fruitDto);
    }
}
