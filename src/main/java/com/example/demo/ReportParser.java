package com.example.demo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReportParser {


    public static List<Report> parse(InputStream xlsxStream){
        List<Report> list = new ArrayList<Report>();
        try {

            XSSFWorkbook workbook = new XSSFWorkbook(xlsxStream);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rows = sheet.iterator();
            // skip first row
            if(rows.hasNext()){
                rows.next();
            }

            while(rows.hasNext()) {
                Row row = rows.next();
                list.add(Report.createFrom(row));
            }

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error in parsing document");
        }
        return list;
    }

    public static void write(List<Report> result, String filename) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Report");

        int rowCount = 0;

//      ---------------- Titles ----------------
        Row row = sheet.createRow(rowCount);
        row.createCell(0).setCellValue("Email");
        row.createCell(1).setCellValue("First name");
        row.createCell(2).setCellValue("Last name");
        row.createCell(3).setCellValue("City");
        row.createCell(4).setCellValue("Province");
        row.createCell(5).setCellValue("Zip code");

        for (Report report: result) {
            row = sheet.createRow(++rowCount);
            row.createCell(0).setCellValue(report.getEmail());
            row.createCell(1).setCellValue(report.getFirstname());
            row.createCell(2).setCellValue(report.getLastname());
            row.createCell(3).setCellValue(report.getCity());
            row.createCell(4).setCellValue(report.getProvince());
            row.createCell(5).setCellValue(report.getZipcode());
        }

        try (FileOutputStream outputStream = new FileOutputStream(filename)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


