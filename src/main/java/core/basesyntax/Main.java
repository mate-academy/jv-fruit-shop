package core.basesyntax;

import core.basesyntax.dao.MagazineDaoImpl;
import core.basesyntax.filework.ReadFromFileImpl;
import core.basesyntax.filework.WriteToFileImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.TypeStrategy;
import core.basesyntax.service.TypeStrategyImpl;
import core.basesyntax.service.strategy.AdditionOperationTypeHandler;
import core.basesyntax.service.strategy.ReduceOperationTypeHandler;
import core.basesyntax.service.strategy.TypeHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Fruit.Type, TypeHandler> typeHandlerMap = new HashMap<>();
        typeHandlerMap.put(Fruit.Type.b, new AdditionOperationTypeHandler());
        typeHandlerMap.put(Fruit.Type.s, new AdditionOperationTypeHandler());
        typeHandlerMap.put(Fruit.Type.r, new AdditionOperationTypeHandler());
        typeHandlerMap.put(Fruit.Type.p, new ReduceOperationTypeHandler());

        TypeStrategy typeStrategy = new TypeStrategyImpl(typeHandlerMap);
        FruitService fruitService = new FruitServiceImpl(new MagazineDaoImpl(), typeStrategy,
                new ReadFromFileImpl(), new WriteToFileImpl());
        fruitService.createReport();
    }
}
