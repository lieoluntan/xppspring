package cn.yx.test.BSF;

import static org.junit.Assert.*;

import org.junit.Test;

import com.YXcrm.service.impl.YXstudentServiceImpl;

public class YXstudentServiceImplTest {
	
	YXstudentServiceImpl yx=new YXstudentServiceImpl();
	
	@Test
	public void test() {
		yx.getMsg();
	}

}
