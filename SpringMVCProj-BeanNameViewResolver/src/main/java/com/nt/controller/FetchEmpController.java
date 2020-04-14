package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

public class FetchEmpController extends AbstractController {
	private EmployeeMgmtService service;
	public FetchEmpController(EmployeeMgmtService service) {
		this.service = service;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<EmployeeDTO> listDTO=null;
		//use service
		listDTO=service.frtchAllEmps();
		return new ModelAndView("show_AllEmp", "listDTO", listDTO);
	}

}
