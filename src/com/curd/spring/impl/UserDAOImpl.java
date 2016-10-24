package com.curd.spring.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.curd.spring.dao.IUserDAO;
import com.curd.spring.vo.User;

public class UserDAOImpl extends JdbcDaoSupport implements IUserDAO{

	@Override
	public void addUser(User user) {
		String sql = "insert into user valuse(?,?,?)";
		this.getJdbcTemplate().update(sql,user.getUsername(),user.getPassword(),user.getClassroom());
	}

	@Override
	public void deleteUser(int id) {
		String sql = "delect from user where id=?";
		this.getJdbcTemplate().update(sql,id);
	}

	@Override
	public void updateUser(User user) {
		String sql = "update user set username=?,password=?,classroom=? where id=?";
		this.getJdbcTemplate().update(sql,user.getUsername(),user.getPassword(),user.getId());
	}

	//�򵥲�ѯ������id��ѯ�������ַ���
	@Override
	public String searchUserName(int id) {
		String sql = "select username,classname from user where id=?";
		// ��������ΪString(String.class)
		return this.getJdbcTemplate().queryForObject(sql, String.class, id);
	}

	@Override
	public User searchUser(int id) {
		String sql = "select * from user where id=?";
		return this.getJdbcTemplate().queryForObject(sql, new UserRowMapper(), id);
	}

	//���Ӳ�ѯ����List����
	@Override
	public List<User> findAll() {
		String sql = "select * from user";
		return this.getJdbcTemplate().query(sql, new UserRowMapper());
	}
	
	class UserRowMapper implements RowMapper<User>{
		//rsΪ���ؽ��������ÿ��Ϊ��λ����
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setClassroom(rs.getString("classname"));
			return user;
		}
		
	}
}
