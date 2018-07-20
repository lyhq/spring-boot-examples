package com.lyhq.web;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lyhq.util.LyhqProperties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProPertiesTest {
	
	@Autowired
    private LyhqProperties lyhqProperties;


    @Test
    public void getHello() throws Exception {
    	System.out.println(lyhqProperties.getTitle());
        Assert.assertEquals(lyhqProperties.getTitle(), "纯洁的微笑");
        Assert.assertEquals(lyhqProperties.getDescription(), "分享生活和技术");
    }

    
    @Test
    public void testMap() throws Exception {
    	Map<String, Long> orderMinTime=new HashMap<String, Long>();
    	long xx=orderMinTime.get("123");
    }

}