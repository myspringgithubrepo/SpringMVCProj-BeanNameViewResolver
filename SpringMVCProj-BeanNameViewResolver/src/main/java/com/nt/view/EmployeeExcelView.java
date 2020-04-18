package com.nt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nt.dto.EmployeeDTO;

public class EmployeeExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		 //craete sheet from workbook
		Sheet s=workbook.createSheet("EmployeeSheet");
		//get the Model data 
		List<EmployeeDTO> listDTO=(List<EmployeeDTO>) map.get("listDTO");
		
		//crate Row from Sheet
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("SR. NUM");
		r.createCell(1).setCellValue("EMP NUM");
		r.createCell(2).setCellValue("NAME");
		r.createCell(3).setCellValue("JOB");
		r.createCell(4).setCellValue("SALARY");
		
		//keeping values to the column
		int i=1;
		for(EmployeeDTO dto:listDTO) {
			Row row=s.createRow(i++);
			row.createCell(0).setCellValue(dto.getSrNo());
			row.createCell(1).setCellValue(dto.getEmpNo());
			row.createCell(2).setCellValue(dto.getEmpName());
			row.createCell(3).setCellValue(dto.getJob());
			row.createCell(4).setCellValue(dto.getSalary());
			
		}

	}

		
	}


