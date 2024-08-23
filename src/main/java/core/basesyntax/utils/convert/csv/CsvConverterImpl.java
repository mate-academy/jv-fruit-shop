package core.basesyntax.utils.convert.csv;

import core.basesyntax.utils.transaction.FruitTransaction;
import core.basesyntax.utils.convert.ReportConverter;
import core.basesyntax.utils.transaction.OperationFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvConverterImpl implements ReportConverter {
    private static final String LINE_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_INDEX = 1;
    private static final int PRODUCT_QUANTITY_INDEX = 2;
    private final String report;

    public CsvConverterImpl(String report) {
        this.report = report;
    }

    public List<FruitTransaction> convert() {
        return processStream(Arrays.stream(report.split(System.lineSeparator())));
    }

    private List<FruitTransaction> processStream(Stream<String> stream) {
        return stream.map(line -> line.split(LINE_SEPARATOR))
                .map(operation -> new FruitTransaction(Integer.parseInt(operation[PRODUCT_QUANTITY_INDEX]),
                        operation[PRODUCT_INDEX],
                        OperationFactory.getOperationFromString(operation[OPERATION_INDEX])))
                .collect(Collectors.toList());
    }
}
