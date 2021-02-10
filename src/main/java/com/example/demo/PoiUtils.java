package com.example.demo;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class PoiUtils {

    public static String readAsString(Cell cell){
        if (cell.getCellTypeEnum() == CellType.NUMERIC){
            return String.valueOf(cell.getNumericCellValue());
        }
        return cell.getStringCellValue();
    }


}

