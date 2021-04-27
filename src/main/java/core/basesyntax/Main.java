package core.basesyntax;

import core.basesyntax.dao.MagazineDaoImpl;
import core.basesyntax.filework.ReadFromFileImpl;
import core.basesyntax.filework.WriteToFileImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.TypeStrategy;
import core.basesyntax.service.TypeStrategyImpl;
import core.basesyntax.service.strategy.BalanceTypeHandler;
import core.basesyntax.service.strategy.PurchaseTypeHandler;
import core.basesyntax.service.strategy.ReturnTypeHandler;
import core.basesyntax.service.strategy.SupplyTypeHandler;
import core.basesyntax.service.strategy.TypeHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Fruit.Type, TypeHandler> typeHandlerMap = new HashMap<>();
        typeHandlerMap.put(Fruit.Type.b, new BalanceTypeHandler());
        typeHandlerMap.put(Fruit.Type.s, new SupplyTypeHandler());
        typeHandlerMap.put(Fruit.Type.r, new ReturnTypeHandler());
        typeHandlerMap.put(Fruit.Type.p, new PurchaseTypeHandler());

        TypeStrategy typeStrategy = new TypeStrategyImpl(typeHandlerMap);
        FruitService fruitService = new FruitServiceImpl(new MagazineDaoImpl(), typeStrategy,
                new ReadFromFileImpl(), new WriteToFileImpl());
        fruitService.createReport();
    }
}
