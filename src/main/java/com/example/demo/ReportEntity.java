package com.example.demo;

import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.Data;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reports")
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private String lastName;
    private String firstName;
    private String city;
    private String province;

    public static ReportEntity createFrom(Report report) {
        ReportEntity reportEntity = new ReportEntity();
        BeanUtils.copyProperties(report, reportEntity);
        return reportEntity;
    }
}
