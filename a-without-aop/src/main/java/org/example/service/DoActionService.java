package org.example.service;

import org.example.bs.ReportSummary;
import org.example.ds.Report;
import org.example.logger.PerformanceLogger;
import org.example.provider.ReportProvider;
import org.example.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static org.example.logger.PerformanceLogger.PerformanceLoggerInfo;

@Service
public class DoActionService {

    private final ReportSummary reportSummary;
    private final ReportProvider reportProvider;
    private final ReportRepository reportRepository;

    public DoActionService(ReportSummary reportSummary,
                           ReportProvider reportProvider,
                           ReportRepository reportRepository) {
        this.reportSummary = reportSummary;
        this.reportProvider = reportProvider;
        this.reportRepository = reportRepository;
    }

    public void doAction() {

        PerformanceLogger logger = new PerformanceLogger();
        PerformanceLoggerInfo performanceLoggerInfo = logger.start("reportProvider.provideReport()");
        Report report = reportProvider.provideReport();
        logger.end(performanceLoggerInfo);

        performanceLoggerInfo = logger.start("reportRepository.saveReport(report)");
        reportRepository.saveReport(report);
        logger.end(performanceLoggerInfo);

        performanceLoggerInfo = logger.start("reportSummary.summaryReport(from, to)");
        reportSummary.summaryReport(LocalDate.of(2023, 4, 10), LocalDate.now());
        logger.end(performanceLoggerInfo);
    }
}
