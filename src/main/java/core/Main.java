package core;

import core.strategy.ReportFactory;

public class Main {

    public static void main(String[] args) {
        ReportFactory reportFactory = new ReportFactory();
        String filePath = "src/main/java/core/db/dataBase.csv";
        String pathTo = "test";
        reportFactory.start(filePath, pathTo);
    }
}
