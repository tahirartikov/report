package com.example.demo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.poi.ss.usermodel.Row;


@Data
@EqualsAndHashCode
@ToString
public class Report {

    @EqualsAndHashCode.Include
    private String email;
    @EqualsAndHashCode.Exclude
    private String lastname;
    @EqualsAndHashCode.Exclude
    private String firstname;
    @EqualsAndHashCode.Exclude
    private String city;
    @EqualsAndHashCode.Exclude
    private String province;
    @EqualsAndHashCode.Exclude
    private String zipcode;

    public static Report createFrom(Row row) {
        Report address = new Report();
        address.setEmail(PoiUtils.readAsString(row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)));
        address.setFirstname(PoiUtils.readAsString(row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)));
        address.setLastname(PoiUtils.readAsString(row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)));
        address.setCity(PoiUtils.readAsString(row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)));
        address.setProvince(PoiUtils.readAsString(row.getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)));
        address.setZipcode(PoiUtils.readAsString(row.getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)));
        return address;
    }
}


