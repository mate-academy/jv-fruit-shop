package core.basesyntax.parser;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.store.StorageService;
import core.basesyntax.store.StorageServiceImpl;
import core.basesyntax.store.strategy.TypeHandler;
import core.basesyntax.validator.Validator;
import core.basesyntax.validator.ValidatorImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ParserImpl implements Parser {
    Validator validator;
    StorageService storageService;
    FruitDao fruitDao;

    public ParserImpl(Map<String, TypeHandler> typeHandlerMap) {
        validator = new ValidatorImpl();
        storageService = new StorageServiceImpl(typeHandlerMap);
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public List<Fruit> parseLines(List<String[]> lines, Set<String> types) {
        int lineNumber = 1;
        for (String[] line : lines) {
            validator.lineValidator(line, lineNumber, types);
            storageService.makeOperationDependsOnType(line, lineNumber);
        }
        return fruitDao.getFullStorage();
    }
}
