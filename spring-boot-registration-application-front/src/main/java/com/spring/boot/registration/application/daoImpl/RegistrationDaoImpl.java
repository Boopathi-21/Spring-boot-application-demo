package com.spring.boot.registration.application.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.spring.boot.registration.application.dao.RegistrationDao;
import com.spring.boot.registration.application.model.RegisterForm;

@Repository
public class RegistrationDaoImpl extends JdbcDaoSupport implements RegistrationDao  {


	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public void insertRecord(RegisterForm data) {
		// TODO Auto-generated method stub
		String sql =  "INSERT INTO Registration " +
				"(name,emailId,password,confirmPassword) VALUES (?,?,?,?)";
		getJdbcTemplate().update(sql, new Object[]{
				data.getName(), data.getMailId(),
				data.getPassword(),data.getConfirmPassword()
		});
	
}

	@Override
	public List<RegisterForm> getAll() {
		String sql = "SELECT * FROM Registration";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		List<RegisterForm> result = new ArrayList<RegisterForm>();
		for(Map<String, Object> row:rows){
			RegisterForm data = new RegisterForm();
			data.setName((String) row.get("name"));
			data.setMailId((String) row.get("emailId"));
			data.setMailId((String) row.get("password"));
			data.setMailId((String) row.get("confirmPassword"));
			result.add(data);
	}
		return result;
	}

}