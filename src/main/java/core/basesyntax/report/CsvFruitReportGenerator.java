package core.basesyntax.report;

import core.basesyntax.fruitentry.FruitEntryService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CsvFruitReportGenerator implements FileReportGenerator {
    private static final List<String> REPORT_HEADING_TOKENS = List.of("fruit", "quantity");
    private static final String EMPTY_REPORT = "";
    private final FruitEntryService fruitEntryService;
    private final String tokenSeparator;

    @Override
    public void generateFileReport(Path pathToReport) {
        String report = generateStringReport();
        try {
            Files.writeString(pathToReport, report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + pathToReport);
        }
    }

    public String generateStringReport() {
        if (REPORT_HEADING_TOKENS.isEmpty()) {
            return EMPTY_REPORT;
        }

        StringBuilder stringBuilder = new StringBuilder(REPORT_HEADING_TOKENS.get(0));
        for (int i = 1; i < REPORT_HEADING_TOKENS.size(); i++) {
            stringBuilder.append(tokenSeparator);
            stringBuilder.append(REPORT_HEADING_TOKENS.get(i));
        }
        stringBuilder.append(System.lineSeparator());

        fruitEntryService.getAllFruitEntries()
                .forEach(fruitEntry ->
                        stringBuilder
                                .append(fruitEntry.getFruitName())
                                .append(tokenSeparator)
                                .append(fruitEntry.getQuantity())
                                .append(System.lineSeparator()));
        return stringBuilder.toString();
    }
}
