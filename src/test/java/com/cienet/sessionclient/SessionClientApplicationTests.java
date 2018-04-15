package com.cienet.sessionclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SessionClientApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void readSessionInfo() throws Exception{
		SessionInfo.readXML();
	}
}
