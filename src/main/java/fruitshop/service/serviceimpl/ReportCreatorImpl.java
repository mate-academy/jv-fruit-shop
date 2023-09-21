package fruitshop.service.serviceimpl;

import fruitshop.service.ReportCreator;
import fruitshop.storage.Storage;

public class ReportCreatorImpl implements ReportCreator {
    private static final String TYPES = "fruit,quantity"
            + System.lineSeparator();
    private static final String SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder(TYPES);
        Storage.getStorage().forEach((key, value) -> stringBuilder.append(key).append(SEPARATOR)
                .append(value).append(System.lineSeparator()));
        return stringBuilder.toString();
    }
}
