package core.basesyntax;

import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;

public class Main {

    public static void main(String[] args) {
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        reportGenerator.makeReport();
    }
}


