package myFruitShop.Service;

import myFruitShop.Service.ReportGenerator;

import java.io.File;

public interface ReportSupplier {
    File writeToFile(ReportGenerator stringReportGenerator, String reportFileName);
}
