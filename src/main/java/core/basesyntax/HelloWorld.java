package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.io.*;
import java.util.*;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    public class Main {
        public static void main(String[] arg) {
            // 1. Read the data from the input CSV file
            String inputFile = "input.csv";
            String outputFile = "output.csv";

            Map<String, Integer> fruitShop = new HashMap<>();

            try (BufferedReader read = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = read.readLine()) != null) {
                    String[] parts = line.split(",");
                    String operation = parts[0].trim();
                    String fruit = parts[1].trim();
                    int quantity = Integer.parseInt(parts[2].trim());

                    int current = fruitShop.getOrDefault(operation, 0);

                    switch (operation) {
                        case "b":
                            fruitShop.put(operation, quantity);
                            break;
                        case "s":
                            fruitShop.put(operation, current + quantity);
                            break;
                        case "p":
                            fruitShop.put(operation, current - quantity);
                            break;
                        case "r":
                            fruitShop.put(operation, current + quantity);
                            break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                writer.write("fruit,quantity");
                writer.newLine();

                for (Map.Entry<String, Integer> entry : fruitShop.entrySet()) {
                    String fruit = entry.getKey();
                    int quantity = entry.getValue();
                    writer.write(fruit + "," + quantity);
                    writer.newLine();
                }

                System.out.println("Отчет успешно записан в файл " + outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}