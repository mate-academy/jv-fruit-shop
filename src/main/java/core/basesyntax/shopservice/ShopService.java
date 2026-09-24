package core.basesyntax.shopservice;

import core.basesyntax.fruittransaction.FruitTransaction;
import core.basesyntax.reportgenerator.ReportGenerator;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> operations);

    public ReportGenerator getRaportGenerator();
}
