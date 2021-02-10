package com.example.demo;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ReportService {


    void saveToDb(MultipartFile file) throws IOException;
}
