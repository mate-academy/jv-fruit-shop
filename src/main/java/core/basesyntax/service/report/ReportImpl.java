package core.basesyntax.service.report;

import core.basesyntax.dto.FruitRecordsDto;
import core.basesyntax.dto.FruitRecordsDtoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.service.transfer.FruitTransfer;
import core.basesyntax.service.transfer.FruitTransferImpl;
import java.util.Map;

public class ReportImpl implements Report {

    @Override
    public void createReport(String fromFileName, String toFilename) {
        FruitRecordsDto fruitRecordsDao = new FruitRecordsDtoImpl();
        FruitTransfer fruitTransfer = new FruitTransferImpl();
        fruitTransfer.transfer(fromFileName);
        fruitRecordsDao.writeDataToFile(toFilename, buildReport());
    }

    private String buildReport() {
        Map<String, Integer> fruitStorage = Storage.fruitStorage;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity")
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruitStorage.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
