import service.CreationReportServiceImpl;

public class Main {
    public static void main(String[] args) {
        CreationReportServiceImpl reportService = new CreationReportServiceImpl();
        reportService.createReportOfDay();
    }
}
