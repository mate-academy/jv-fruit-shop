package core.basesyntax.fileservice;

import core.basesyntax.dto.ProductDto;
import java.util.ArrayList;
import java.util.List;

public class CsvParser implements Parser {
    @Override
    public List<ProductDto> parse(List<String> data) {
        ProductDto productDto;
        List<ProductDto> productDtoList = new ArrayList<>();
        for (String datum : data) {
            String[] product = datum.split(",");
            productDto = new ProductDto(product[0], product[1], Integer.parseInt(product[2]));
            productDtoList.add(productDto);
        }
        return productDtoList;
    }
}
