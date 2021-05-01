package core.basesyntax.Service;

import core.basesyntax.Model.FruitRecordDto;

public interface Validator {
    boolean checkAmount(FruitRecordDto fruit);
}
