package core.basesyntax.service;

import core.basesyntax.infratructure.persistence.FruitRepository;
import core.basesyntax.service.usecases.FruitUseService;
import core.basesyntax.service.usecases.PushareFruitImpl;
import core.basesyntax.service.usecases.ReturnFruitToBalanceImpl;
import core.basesyntax.service.usecases.SupplyFruitToBalanceImpl;

import java.util.Map;


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
