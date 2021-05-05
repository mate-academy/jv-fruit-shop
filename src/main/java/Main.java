import core.basesyntax.dto.ProductDto;
import core.basesyntax.fileservice.CsvParser;
import core.basesyntax.fileservice.CsvReader;
import core.basesyntax.fileservice.CsvWriter;
import core.basesyntax.operations.AddOperation;
import core.basesyntax.operations.BalanceOperation;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.PurchaseOperation;
import core.basesyntax.storage.Storage;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Operation purchaseOperation = new PurchaseOperation();
        Operation addOperation = new AddOperation();
        Operation balanceOperation = new BalanceOperation();
        CsvParser parser = new CsvParser();
        CsvReader csvReader = new CsvReader();
        CsvWriter csvWriter = new CsvWriter();
        List<String> list = csvReader.readFromFile("shop_operations.csv");
        List<ProductDto> products = parser.parse(list);

        for (ProductDto productDto : products) {
            switch (productDto.getOperationType()) {
                case "b":
                    balanceOperation.apply(productDto);
                    break;
                case "r":
                case "s":
                    addOperation.apply(productDto);
                    break;
                case "p":
                    purchaseOperation.apply(productDto);
                    break;
                default: throw new RuntimeException("Invalid operation");
            }
        }
        csvWriter.writeToFile("report.csv", Storage.toList());
    }
}
