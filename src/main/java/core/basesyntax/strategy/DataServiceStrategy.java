package core.basesyntax.strategy;

import core.basesyntax.service.dataservice.DataService;

public interface DataServiceStrategy {
    DataService get(String operationType);
}
