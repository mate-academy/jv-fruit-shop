package core.basesyntax.application;

import core.basesyntax.model.impl.ReadFromFileImpl;
import core.basesyntax.model.service.ReadFromFile;

public class Main {
    private static final ReadFromFile readFromFile = new ReadFromFileImpl();
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/input.csv";
        System.out.println(readFromFile.readFile(inputFilePath));
    }
}
