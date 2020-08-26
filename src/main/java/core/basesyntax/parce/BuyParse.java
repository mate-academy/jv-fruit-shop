package core.basesyntax.parce;

import core.basesyntax.operation.Buy;

import java.util.List;

public class BuyParse implements ParseOperation<Buy>{
    @Override
    public Buy parse(List<String> data) {
        Buy buy = new Buy();
        buy.setTypeOfFruit(data.get(1));
        buy.setQuantity(Integer.parseInt(data.get(2)));
        return buy;
    }
}
