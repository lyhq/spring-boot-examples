package com.lyhq.domain;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() throws Exception {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		System.out.println(formattedDate);
//		userRepository.save(new User("aa", "aa123456", "aa@126.com", "aa1", formattedDate));
//		userRepository.save(new User("bb", "bb123456", "bb@126.com", "bb1", formattedDate));
//		userRepository.save(new User("cc", "cc123456", "cc@126.com", "cc1", formattedDate));
		
//		User user = userRepository.findByUserName("aa");
//		System.out.println(user);
//		userRepository.delete(user);
		
		//
		 Assert.assertEquals(9, userRepository.findAll().size());
		 Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb","cc@126.com").getNickName());
		 userRepository.delete(userRepository.findByUserName("aa"));
	}

}