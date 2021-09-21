package core.basesyntax.service.report;

import core.basesyntax.service.fileservice.FruitRecordsDto;
import core.basesyntax.service.fileservice.FruitRecordsDtoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.fruitservice.FruitService;
import core.basesyntax.service.fruitservice.FruitServiceImpl;
import java.util.Map;

public class ReportCreatorImpl implements Report {

    @Override
    public void createReport(String fromFileName, String toFilename) {
        FruitRecordsDto fruitRecordsDao = new FruitRecordsDtoImpl();
        FruitService fruitTransfer = new FruitServiceImpl();
        fruitTransfer.safe(fromFileName);
        fruitRecordsDao.writeDataToFile(toFilename, buildReport());
    }

    private String buildReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity")
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : Storage.fruitStorage.entrySet()) {
            stringBuilder.append(entry.getKey().getFruit())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
