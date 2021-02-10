package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{

    private final ReprotRepository reprotRepository;

    public ReportServiceImpl(ReprotRepository reprotRepository) {
        this.reprotRepository = reprotRepository;
    }

    @Override
    public void saveToDb(MultipartFile file) throws IOException {
        List<Report> reports = ReportParser.parse(file.getInputStream());
        List<ReportEntity> entities =  new ArrayList<>();
        reports.forEach(report -> entities.add(ReportEntity.createFrom(report)));
        reprotRepository.saveAll(entities);
    }
}
