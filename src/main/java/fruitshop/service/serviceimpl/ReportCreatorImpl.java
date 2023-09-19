package fruitshop.service.serviceimpl;

import fruitshop.service.ReportCreator;
import fruitshop.storage.Storage;

public class ReportCreatorImpl implements ReportCreator {
    private static final String TYPES = "fruit,quantity"
            + System.lineSeparator();
    private static final String SEPARATOR = ",";
    private final StringBuilder stringBuilder = new StringBuilder(TYPES);

    @Override
    public String createReport() {
        Storage.getStorage().forEach((key, value) -> stringBuilder.append(key).append(SEPARATOR)
                .append(value).append(System.lineSeparator()));
        return stringBuilder.toString();
    }
}
