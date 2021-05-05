package core.basesyntax.fileservice;

import core.basesyntax.dto.ProductDto;
import core.basesyntax.storage.Storage;

import java.util.ArrayList;
import java.util.List;

public class CsvParser implements Parser {
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int FRUIT_QUANTITY = 2;
    private static final String CSV_SEPARATOR = ",";
    @Override
    public List<ProductDto> parse(List<String> data) {
        ProductDto productDto;
        List<ProductDto> productDtoList = new ArrayList<>();
        for (String datum : data) {
            String[] product = datum.split(CSV_SEPARATOR);
            productDto = new ProductDto(product[OPERATION], product[FRUIT_NAME],
                    Integer.parseInt(product[FRUIT_QUANTITY]));
            productDtoList.add(productDto);
        }
        return productDtoList;
    }
}
