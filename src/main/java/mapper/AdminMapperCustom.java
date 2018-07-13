package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import po.Admin;
import po.AdminExample;

public interface AdminMapperCustom {

	List<Admin> queryAdminByUsername(Admin admin);
}