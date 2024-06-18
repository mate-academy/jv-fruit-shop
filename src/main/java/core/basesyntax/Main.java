package core.basesyntax;

import core.basesyntax.config.AppConfig;

public class Main {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        FruitShopApplication app = new FruitShopApplication(appConfig);
        app.run("reportToRead.csv", "finalReport.csv");
    }
}
