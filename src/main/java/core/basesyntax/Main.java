package core.basesyntax;

import core.basesyntax.service.Application;

public class Main {
    public static void main(String[] args) {
        Application newStart = new Application();
        newStart.startApp("src/test/resources/Input.csv");
        Application finalWrite = new Application();
        finalWrite.writingToFile("src/test/resources/Output.csv");
    }
}
