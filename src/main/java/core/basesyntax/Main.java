package core.basesyntax;

import core.basesyntax.service.Application;

public class Main {
    public static void main(String[] args) {
        Application application = new Application();
        application.startApp("src/test/resources/Input.csv");
        application.writingToFile("src/test/resources/Output.csv");
    }
}
