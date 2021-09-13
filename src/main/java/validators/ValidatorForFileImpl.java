package validators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ValidatorForFileImpl implements ValidatorForFile {
    private static final String CSV_SEPARATOR = ",";

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
                    System.out.println("Not found operation or name of fruit!!!");
                    return false;
                }
                if (quantity < 0) {
                    System.out.println("The quality must be greater than zero!!!");
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Quality is not correct!!!");
            return false;
        } catch (IOException e) {
            System.out.println("Error!!! File not found!!!");
            return false;
        }
    }
}
