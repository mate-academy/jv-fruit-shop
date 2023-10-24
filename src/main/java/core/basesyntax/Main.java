package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.*;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ReadFromCsvFileService reader = new ReadFromCsvFileServiceImpl();
        DataConvertService convertor = new DataConvertServiceImpl();
        DataProcessService processor = new DataProcessServiceImpl();
        CreateReportService reportCreator = new CreateReportServiceImpl();
        WriteToCsvFileService writer = new WriteToCsvFileServiceImpl();

        processor.processFruits(convertor.convert(reader.readFile("fruits.csv")));
        writer.write(reportCreator.createReport());
    }
}
