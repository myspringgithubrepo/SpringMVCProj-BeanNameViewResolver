package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

public class ViewController extends AbstractController {
	private EmployeeMgmtService service=null;
	
	public ViewController(EmployeeMgmtService service) {
		this.service = service;
	}


	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		List<EmployeeDTO> listDTO=null;
		//use service
		listDTO=service.frtchAllEmps();
	if(req.getParameter("type").equalsIgnoreCase("excel"))
		return new ModelAndView("excelView", "listDTO", listDTO);
	else
		return new ModelAndView("pdfView", "listDTO", listDTO);
	}

}
