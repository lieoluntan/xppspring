package cn.yx.test.LH;

import static org.junit.Assert.*;

import org.junit.Test;

import com.YXcrm.service.impl.RecordServiceImpl;

public class RecordServiceImplTest {
	RecordServiceImpl rs = new RecordServiceImpl();
	@Test
	public void testGetMsg() {
		rs.getMsg();
	}

}
