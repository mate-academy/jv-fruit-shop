package core.basesyntax.rearfilewithproducts;

import errors.InvalidDataFromFile;
import errors.InvalidFileExtension;
import fruittransaction.Products;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFileWithProductsImpl implements ReadFileWithProducts {

    @Override
    public List<Products> readFile(File file) {
        if (!file.getName().endsWith(".csv")) {
            throw new InvalidFileExtension("Invalid file extension, extension must be 'csv'.");
        }

        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String line;
        Scanner scanner;
        int index = 0;
        List<Products> products = new ArrayList<>();

        while (true) {
            try {
                if ((line = bufferedReader.readLine()) == null) {
                    break;
                }
                Products products1 = new Products();
                scanner = new Scanner(line);
                scanner.useDelimiter(",");
                while (scanner.hasNext()) {
                    String data = scanner.next();
                    if (index == 0) {
                        products1.setType(data);
                    } else if (index == 1) {
                        products1.setFruit(data);
                    } else if (index == 2) {
                        products1.setQuantity(Integer.parseInt(data));
                    } else {
                        throw new InvalidDataFromFile("Incorrect data from file" + file);
                    }
                    index++;
                }
                index = 0;
                products.add(products1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't close file" + file, e);
        }
        return products;
    }
}
