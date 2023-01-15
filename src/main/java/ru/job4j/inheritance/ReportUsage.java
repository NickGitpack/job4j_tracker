package ru.job4j.inheritance;

import java.sql.SQLOutput;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new TextReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);
        HtmlReport hreport = new HtmlReport();
        String htext = hreport.generate("Report's name", "Report's body");
        System.out.println(htext);
        JSONReport jreport = new JSONReport();
        String jtext = jreport.generate("Report's name", "Report's body");
        System.out.println(jtext);
    }
}
