package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import mapper.AdminMapperCustom;
import po.Admin;
import service.AdminService;

@Transactional
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapperCustom adminMapperCustom;
	
	@Override
	public List<Admin> queryAdminByUsername(Admin admin) {
		return adminMapperCustom.queryAdminByUsername(admin);
	}

}
