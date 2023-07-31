package core;

import core.strategy.ReportFactory;

public class Main {

    public static void main(String[] args) {
        ReportFactory reportFactory = new ReportFactory();
        String fromPath = "src/main/java/core/db/dataBase.csv";
        String toPath = "dailyReport1";
        reportFactory.start(fromPath, toPath);
    }
}
