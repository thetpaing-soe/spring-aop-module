package org.example.service;

import org.example.bs.ReportSummary;
import org.example.ds.Report;
import org.example.provider.ReportProvider;
import org.example.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


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

        Report report = reportProvider.provideReport();
        reportRepository.saveReport(report);
        reportSummary.summaryReport(LocalDate.of(2023, 4, 10), LocalDate.now());
    }
}
