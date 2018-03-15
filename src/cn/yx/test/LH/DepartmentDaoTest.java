package cn.yx.test.LH;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.YXcrm.controller.DengLuControl;
import com.YXcrm.controller.DepartmentController;
import com.YXcrm.controller.DphoneController;
import com.YXcrm.dao.DepartmentDao;
import com.YXcrm.dao.impl.DepartmentDaoImpl;
import com.YXcrm.model.Department;
import com.YXcrm.model.Dphone;
import com.YXcrm.system.model.UserPK;

public class DepartmentDaoTest {
	DphoneController dtt = new DphoneController();
	Dphone d = new Dphone();
	@Test
	public void testInsert() {
		//dtt.qqiuchocie("test",d);
	}

	/*@Test
	public void testGetdMByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByUuid() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateOnOff() {
		fail("Not yet implemented");
	}*/

}
