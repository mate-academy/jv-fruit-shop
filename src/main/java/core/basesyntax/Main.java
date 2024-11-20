package core.basesyntax;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ReadDatafile readDataFile = new ReadDatafile();
        GenerateRaport generateRaport = new GenerateRaport();

        Map<String, Integer> fruitQuantity = readDataFile.getInputDataFromFile();

        generateRaport.generateRaport(fruitQuantity);

    }
}
