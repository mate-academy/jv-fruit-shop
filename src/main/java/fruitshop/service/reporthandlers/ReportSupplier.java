package fruitshop.service.reporthandlers;

import java.io.File;

public interface ReportSupplier {
    File writeToFile(ReportGenerator stringReportGenerator, String reportFileName);
}
