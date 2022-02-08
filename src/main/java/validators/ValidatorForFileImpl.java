package validators;

import static shop.service.ShopServiceImpl.CSV_SEPARATOR;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ValidatorForFileImpl implements ValidatorForFile {

    @Override
    public boolean test(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine();
            String[] lines = reader.lines().toArray(String[]::new);
            for (String line : lines) {
                String[] operationNameQuality = line.split(CSV_SEPARATOR);
                String operation = operationNameQuality[0];
                String fruitName = operationNameQuality[1];
                int quantity = Integer.parseInt(operationNameQuality[2]);
                if (operation.strip().equals("") || fruitName.strip().equals("")) {
                    throw new RuntimeException("Not found operation or name of fruit!!!");
                }
                if (quantity < 0) {
                    throw new RuntimeException("The quality must be greater than zero!!!");
                }
            }
            return true;
        } catch (NumberFormatException e) {
            throw new RuntimeException("Quality is not correct!!!");
        } catch (IOException e) {
            throw new RuntimeException("Error!!! File not found!!!");
        }
    }
}
