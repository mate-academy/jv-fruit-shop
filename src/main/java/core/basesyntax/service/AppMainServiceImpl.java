package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.report.convertdata.DataConvertor;
import core.basesyntax.report.input.Reader;
import core.basesyntax.report.output.Writer;
import core.basesyntax.report.report.ReportGenerator;
import java.util.List;

public class AppMainServiceImpl implements AppMainService {
    private static final String FILE_READ_SRC = "src/main/resources/reportToRead.csv";
    private static final String FILE_WRITE_SRC = "src/main/resources/finalReport.csv";
    private final Reader reader;
    private final DataConvertor dataConvertor;
    private final ShopService shopService;
    private final ReportGenerator reportGenerator;
    private final Writer writer;

    public AppMainServiceImpl(
            Reader reader,
            DataConvertor dataConvertor,
            ShopService shopService,
            ReportGenerator reportGenerator,
            Writer writer) {
        this.reader = reader;
        this.dataConvertor = dataConvertor;
        this.shopService = shopService;
        this.reportGenerator = reportGenerator;
        this.writer = writer;
    }

    @Override
    public void run() {
        List<String> rawLines = reader.read(FILE_READ_SRC);

        // Step 2: Convert to FruitOperation list
        List<FruitOperation> operations = dataConvertor.convertToTransaction(rawLines);

        // Step 3: Apply operations
        shopService.changeQuantityStore(operations);

        // Step 4: Generate report
        String report = reportGenerator.getReport(Storage.SHOP_STORE);

        // Step 5: Write to output file
        writer.write(report, FILE_WRITE_SRC);
    }
}
