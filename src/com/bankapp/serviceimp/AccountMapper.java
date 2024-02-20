package com.bankapp.serviceimp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bankapp.model.Account;

public class AccountMapper implements RowMapper<Account>{

	@Override
	public Account mapRow(ResultSet rs, int arg1) throws SQLException {
		Account ac = new Account();
		ac.setAcno(rs.getLong("accountno"));
		ac.setAddharno(rs.getLong("addharno"));
		ac.setAddress(rs.getString("address"));
		ac.setBalance(rs.getDouble("balance"));
		ac.setGender(rs.getString("gender"));
		ac.setMobileno(rs.getLong("mobile"));
		ac.setName(rs.getString("name"));
		ac.setPanno(rs.getString("panno"));
		return ac;
	}

}
