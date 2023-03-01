package fruitoperations;

import createfileforproducts.CreateNewFileForProductsImpl;
import errors.ErrorWritingDataToFile;
import errors.InvalidFileExtension;
import fruittransaction.Operation;
import fruittransaction.Products;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FruitOperationsImpl implements FruitOperations {
    private CreateNewFileForProductsImpl createNewFileForProducts;

    @Override
    public List<String> operation(List<Products> products) {
        List<Products> completeList = products;
        List<String> result = new ArrayList<>();

        for (Products product : products) {
            if (product.getType().equals(Operation.SUPPLY.getCode())) {
                for (Products products1 : completeList) {
                    if (product.getFruit().equals(products1.getFruit())
                            && products1.getType().equals(Operation.BALANCE.getCode())) {
                        products1.setQuantity(product.getQuantity() + products1.getQuantity());
                    }
                }
            } else if (product.getType().equals(Operation.PURCHASE.getCode())) {
                for (Products products1 : completeList) {
                    if (product.getFruit().equals(products1.getFruit())
                            && products1.getType().equals(Operation.BALANCE.getCode())) {
                        products1.setQuantity(products1.getQuantity() - product.getQuantity());
                    }
                }
            } else if (product.getType().equals(Operation.RETURN.getCode())) {
                for (Products products1 : completeList) {
                    if (product.getFruit().equals(products1.getFruit())
                            && products1.getType().equals(Operation.BALANCE.getCode())) {
                        products1.setQuantity(products1.getQuantity() + product.getQuantity());
                    }
                }
            }
        }

        List<Products> collect = completeList.stream()
                .limit(2)
                .collect(Collectors.toList());

        result.add("fruit, quantity");

        for (Products products1 : collect) {
            result.add(products1.getFruit() + ", " + products1.getQuantity());
        }

        return result;
    }

    @Override
    public void writeDataInFile(List<String> dataForFile, String nameForNewFile) {
        if (!nameForNewFile.endsWith(".csv")) {
            throw new InvalidFileExtension("Incorrect files name");
        }

        File file = createNewFileForProducts.createFile(nameForNewFile);

        try (PrintWriter writer = new PrintWriter(file)) {
            StringBuilder builder = new StringBuilder();

            for (String s : dataForFile) {
                String[] strings = s.split(",");
                for (String string : strings) {
                    builder.append(string).append(",");
                }
                builder.append('\n');
            }
            writer.write(builder.toString());
            writer.close();
        } catch (FileNotFoundException e) {
            throw new ErrorWritingDataToFile("Can't write data in file!");
        }
    }
}
