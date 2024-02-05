package core.basesyntax.service.parser;

import core.basesyntax.model.FruitResultingRow;
import core.basesyntax.model.FruitTransactionRow;
import java.util.List;
import java.util.stream.Collectors;

public class FileServiceImpl implements FileService {
    private static final int NUM_OF_LINES_TO_SKIP_AT_BEGIN_CSV = 1;
    private static final String CSV_HEADER_ROW = FruitResultingRow.getFieldsForCsvHeaderRow();
    private static final int CSV_HEADER_ROW_INDEX = 0;

    @Override
    public List<String> reportObjectsToStrings(List<FruitResultingRow> resultingRows) {
        List<String> outputFileLines = resultingRows
                .stream()
                .map(FruitResultingRow::toCsv)
                .collect(Collectors.toList());

        outputFileLines.add(CSV_HEADER_ROW_INDEX, CSV_HEADER_ROW);
        return outputFileLines;
    }

    @Override
    public List<FruitTransactionRow> parseTransactions(List<String> fileLines) {
        return fileLines
                .stream()
                .skip(NUM_OF_LINES_TO_SKIP_AT_BEGIN_CSV)
                .map(FruitTransactionRow::of)
                .toList();
    }
}
