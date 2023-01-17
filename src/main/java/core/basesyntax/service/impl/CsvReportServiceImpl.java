//package core.basesyntax.service.impl;
//
//import com.opencsv.CSVWriter;
//import core.basesyntax.service.ReportService;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Map;
//
//public class CsvReportServiceImpl implements ReportService {
//    @Override
//    public void generateReport(Map<String, Integer> fruits, String pathToFile) {
//        File file = new File(pathToFile);
//        try {
//            FileWriter outputfile = new FileWriter(file);
//            CSVWriter writer = new CSVWriter(outputfile);
//            String[] header = {"fruit", "quantity"};
//            writer.writeNext(header);
//            for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
//                writer.writeNext(new String[]{entry.getKey(), String.valueOf(entry.getValue())});
//            }
//            writer.close();
//        } catch (IOException e) {
//            throw new RuntimeException("Can't write the file " + pathToFile, e);
//        }
//    }
//}
