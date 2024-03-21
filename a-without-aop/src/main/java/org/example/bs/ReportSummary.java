package org.example.bs;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ReportSummary {

    public void summaryReport(LocalDate from, LocalDate to) {

        System.out.println("report summary start.");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("report summary end.");
    }
}
