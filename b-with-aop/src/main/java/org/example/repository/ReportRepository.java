package org.example.repository;

import org.example.annotation.PerformanceMetric;
import org.example.ds.Report;
import org.springframework.stereotype.Component;

@Component
@PerformanceMetric
public class ReportRepository {

    public void saveReport(Report report) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Report Saved.");
    }
}
