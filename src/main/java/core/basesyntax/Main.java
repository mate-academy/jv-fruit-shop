package core.basesyntax;

import core.basesyntax.service.ReportWriter;

public class Main {
    public static void main(String[] args) {
        ReportWriter reportWriter = new ReportWriter();
        reportWriter.getReport("src/test/resources/single_fruit.csv");
    }

}
