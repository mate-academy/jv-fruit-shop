package service;

import dao.FruitTransactionDao;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ShopServiceImpl implements ShopService {
    private static final Path DATA_PATH = Paths.get("src/main/resources/database.Csv");
    private static final Path REPORT_PATH = Paths.get("src/main/resources/report.Csv");

    private ReaderService readerService;
    private WriterService writerService;
    private FruitTransactionDao fruitTransactionDao;
    private ReportService reportService;

    public ShopServiceImpl(FruitTransactionDao fruitTransactionDao, ReaderService readerService,
                           WriterService writerService, ReportService reportService) {
        this.fruitTransactionDao = fruitTransactionDao;
        this.readerService = readerService;
        this.writerService = writerService;
        this.reportService = reportService;
    }

    @Override
    public boolean addTransactions() {
        return fruitTransactionDao.addAll(readerService.read(DATA_PATH));
    }

    @Override
    public boolean createReport() {
        return writerService.write(reportService
                .createReport(fruitTransactionDao.getAll()), REPORT_PATH);
    }
}
