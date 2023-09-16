package fruitshop.service.serviceimpl;

import fruitshop.service.Report;
import fruitshop.storage.Storage;

public class ReportImpl implements Report {
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
