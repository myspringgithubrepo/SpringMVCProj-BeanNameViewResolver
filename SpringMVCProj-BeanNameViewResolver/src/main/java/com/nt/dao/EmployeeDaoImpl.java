package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.nt.bo.EmployeeBO;

public final class EmployeeDaoImpl implements EmployeeDao {
	private JdbcTemplate jt;
	private static final String GET_ALLEMP_QUERY="SELECT EMPNO,ENAME,JOB,SAL FROM EMP";
	
	public EmployeeDaoImpl(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	@Override
	public List<EmployeeBO> getAllEmps() {
		List<EmployeeBO> listBO=jt.query(GET_ALLEMP_QUERY, new EmployeeExtractor());
		return listBO;
	}
	
	private class EmployeeExtractor implements ResultSetExtractor<List<EmployeeBO>>{
		@Override
		public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<EmployeeBO> listBO=null;
			EmployeeBO bo=null;
			listBO=new ArrayList<EmployeeBO>();
			while(rs.next()) {
				bo=new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEmpName(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSalary(rs.getDouble(4));
				listBO.add(bo);
			}
			return listBO;
		}
	
	}

}

