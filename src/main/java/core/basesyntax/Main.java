package core.basesyntax;

import core.basesyntax.model.FruitDto;
import core.basesyntax.service.CreateReportImpl;
import core.basesyntax.service.CreateReportText;
import core.basesyntax.service.ReadService;
import core.basesyntax.service.WriteDataToFile;
import java.util.List;

public class Main {
    private static ReadService readService = new ReadService();

    public static void main(String[] args) {
        String fromFileName = "src/main/resources/Input.cvs";
        String toFileName = "src/main/resources/report.cvs";
        List<FruitDto> data = readService.readData(fromFileName);
        CreateReportText generate = new CreateReportText();
        generate.generateReport(data);
        CreateReportImpl report = new CreateReportImpl();
        String res = report.report();
        WriteDataToFile writer = new WriteDataToFile();
        writer.writeToFile(res, toFileName);
    }
}
