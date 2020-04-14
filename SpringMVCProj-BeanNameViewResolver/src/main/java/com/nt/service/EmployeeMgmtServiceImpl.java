package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDao;
import com.nt.dto.EmployeeDTO;

public final class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	private EmployeeDao dao;
	public EmployeeMgmtServiceImpl(EmployeeDao dao) {
		this.dao = dao;
	}
	@Override
	public List<EmployeeDTO> frtchAllEmps() {
		List<EmployeeDTO> listDTO=new ArrayList<EmployeeDTO>();
		List<EmployeeBO> listBO=null;
		//use service
		listBO=dao.getAllEmps();
		//convert listBO to listDTO
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);		
		});
		return listDTO;
	}

}
