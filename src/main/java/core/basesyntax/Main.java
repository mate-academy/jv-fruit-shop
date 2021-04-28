package core.basesyntax;

import core.basesyntax.fruitshop.file.reader.TaskReader;
import core.basesyntax.fruitshop.file.reader.TaskReaderImpl;
import core.basesyntax.fruitshop.report.generator.ReportGenerator;
import core.basesyntax.fruitshop.report.generator.ReportGeneratorImpl;

public class Main {
    public static void main(String[] args) {
        TaskReader taskReader = new TaskReaderImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        reportGenerator.generateReport("src/main/resources/Report.csv",
                taskReader.readFile("src/main/resources/InputFile.csv"));
    }
}
