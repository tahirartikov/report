package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("report/upload")
    public ResponseEntity<?> getReports(MultipartFile file) {
         try {
            reportService.saveToDb(file);
        } catch (IOException e) {
            ResponseEntity.badRequest();
        }
        return ResponseEntity.ok("job done!!!");
    }
}
