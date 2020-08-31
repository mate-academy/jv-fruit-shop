package core.basesyntax.fileservice;

import core.basesyntax.storeservice.OperationSwitcher;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_TYPE_INDEX = 1;
    private static final int EXP_DATE_INDEX = 2;
    private static final int QUANTITY_INDEX = 3;
    private static final String CSV_REGEX = ", ";
    private final OperationSwitcher switcher = new OperationSwitcher();

    public List<ProductDto> parseData(List<String> inputData) {
        List<ProductDto> productData = new ArrayList<>();
        for (String line : inputData) {
            String[] data;
            try {
                data = line.split(CSV_REGEX);
            } catch (RuntimeException exception) {
                throw new RuntimeException("No arguments to parse", exception);
            }
            try {
                productData.add(new ProductDto(switcher.getOperation(data[OPERATION_INDEX]),
                        data[PRODUCT_TYPE_INDEX],
                        LocalDate.parse(data[EXP_DATE_INDEX]),
                        Integer.parseInt(data[QUANTITY_INDEX])));
            } catch (RuntimeException exception) {
                throw new RuntimeException("Invalid format of input data", exception);
            }
        }
        return productData;
    }
}
