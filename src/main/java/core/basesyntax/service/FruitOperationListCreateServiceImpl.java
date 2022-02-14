package core.basesyntax.service;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.inter.FruitOperationListCreateService;
import core.basesyntax.service.inter.Mapper;
import core.basesyntax.service.inter.Validator;
import java.util.ArrayList;
import java.util.List;

public class FruitOperationListCreateServiceImpl implements FruitOperationListCreateService {
    @Override
    public List<FruitOperation> getFruitOperationsList(List<String> lines) {
        List<FruitOperation> fruitOperations = new ArrayList<>();
        Mapper<String, FruitOperation> mapper = new MapperImpl();
        Validator<String> validator = new FruitOperationValidator();
        for (String data: lines) {
            validator.validate(data);
            fruitOperations.add(mapper.map(data));
        }
        return fruitOperations;
    }
}
