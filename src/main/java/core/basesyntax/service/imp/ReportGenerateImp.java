package core.basesyntax.service.imp;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerate;
import java.util.stream.Collectors;

public class ReportGenerateImp implements ReportGenerate {
    @Override
    public String report() {
        return Storage.getFruitBalance()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + ";" + entry.getValue())
                .collect(Collectors.joining("\n", "fruit;quantity\n", ""));
    }
}
