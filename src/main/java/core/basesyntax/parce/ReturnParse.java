package core.basesyntax.parce;

import core.basesyntax.operation.Return;
import core.basesyntax.operation.Supply;

import java.util.List;

public class ReturnParse implements ParseOperation<Return>{
    @Override
    public Return parse(List<String> data) {
        Return returnOperation = new Return();
        returnOperation.setTypeOfFruit(data.get(1));
        returnOperation.setQuantity(Integer.parseInt(data.get(2)));
        return returnOperation;
    }
}
