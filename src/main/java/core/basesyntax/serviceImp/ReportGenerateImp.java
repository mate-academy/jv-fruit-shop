package core.basesyntax.serviceImp;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerate;
import java.util.stream.Collectors;

public class ReportGenerateImp implements ReportGenerate {
    @Override
    public String report() {
        return Storage.fruitBalance
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + ";" + entry.getValue())
                .collect(Collectors.joining("\n", "fruit;quantity\n", ""));
    }
}
