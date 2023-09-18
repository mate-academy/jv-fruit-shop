package core.basesyntax;

import core.basesyntax.service.workwithfile.CreateReportFile;

public class Main {
    public static void main(String[] args) {
        CreateReportFile reportFile = new CreateReportFile();
        reportFile.createReportFile();
    }
}
