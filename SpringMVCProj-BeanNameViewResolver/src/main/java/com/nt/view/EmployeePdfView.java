package com.nt.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.dto.EmployeeDTO;

public class EmployeePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter writer,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
        res.addHeader("Content-Disposition", "attachment;filename=emp.pdf");
		Paragraph p=new Paragraph("Employee Report");
		doc.add(p);
		List<EmployeeDTO> listDTO=(List<EmployeeDTO>) map.get("listDTO");
		//craete table and add to Document
		PdfPTable table=new PdfPTable(5);
		table.addCell("SR. NUM");
		table.addCell("EMP NUM");
		table.addCell("NAME");
		table.addCell("JOB");
		table.addCell("SALARY");
		for(EmployeeDTO dto:listDTO) {
			table.addCell(String.valueOf(dto.getSrNo()));
			table.addCell(String.valueOf(dto.getEmpNo()));
			table.addCell(dto.getEmpName());
			table.addCell(dto.getJob());
			table.addCell(String.valueOf(dto.getSalary()));    
		}

		doc.add(table);
		doc.add(new Paragraph(new Date().toString()));

	}

}
