package core.basesyntax.service.operationwithdata;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.fruitmodel.Fruit;
import core.basesyntax.validate.ValidationSubtractOperation;
import core.basesyntax.validate.ValidationSubtractOperationValue;
import java.util.Optional;

public class SubtractOperation implements FruitOperationService {
    private ValidationSubtractOperation validationSubtractOperation
            = new ValidationSubtractOperationValue();

    @Override
    public int apply(FruitDto fruitDto) {
        FruitDao fruitDao = new FruitDaoImpl();
        Fruit fruit = new Fruit(fruitDto.getFruitName());
        Optional<Integer> currentQuantityFruit =
                Optional.ofNullable(fruitDao.get(fruit));
        int newBalance = 0;
        if (currentQuantityFruit.isPresent()
                && validationSubtractOperation
                .validateDeleteOperation(currentQuantityFruit.get(), fruitDto.getCountFruit())) {
            newBalance = currentQuantityFruit.get() - fruitDto.getCountFruit();
            fruitDao.save(fruit, newBalance);
        }
        return newBalance;
    }
}
