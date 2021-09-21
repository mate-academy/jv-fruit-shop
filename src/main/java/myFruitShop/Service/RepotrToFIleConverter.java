package myFruitShop.Service;

import myFruitShop.Service.ReportGenerator;
import myFruitShop.Service.ReportSupplier;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RepotrToFIleConverter implements ReportSupplier {

   public File writeToFile(ReportGenerator stringReportGenerator, String reportFileName) {
       String report = stringReportGenerator.generateReport();
       File dailyReport = new File(reportFileName);
       try {
           dailyReport.createNewFile();
       } catch (IOException e) {
           throw new RuntimeException("Can't create the file", e);
       }
       try(BufferedWriter writer = new BufferedWriter(new FileWriter(dailyReport))) {
           writer.write(report);
       } catch (IOException e) {
           throw new RuntimeException("Can`t write to file", e);
       }
       return dailyReport;
   }
}
