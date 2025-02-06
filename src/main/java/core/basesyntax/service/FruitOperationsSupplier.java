package core.basesyntax.service;

import core.basesyntax.infratructure.persistence.FruitRepository;
import core.basesyntax.service.usecases.FruitUseService;
import core.basesyntax.service.usecases.PushareFruitImpl;
import core.basesyntax.service.usecases.ReturnFruitToBalanceImpl;
import core.basesyntax.service.usecases.SupplyFruitToBalanceImpl;

import java.util.Map;

public class FruitOperationsSupplier {

    public static void supply(Map<Operation, FruitUseService> fruitUseServiceMap, FruitRepository fruitRepository) {
        fruitUseServiceMap.put(Operation.SUPPLY, new SupplyFruitToBalanceImpl(fruitRepository));
        fruitUseServiceMap.put(Operation.PURCHASE, new PushareFruitImpl(fruitRepository));
        fruitUseServiceMap.put(Operation.RETURN, new ReturnFruitToBalanceImpl(fruitRepository));
    }

    public enum Operation {
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}