package com.blogApp.blog;

import com.blogApp.blog.repositories.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	private UserRepo userRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void repoTest(){
		String className = userRepo.getClass().getName();
		String packageName = userRepo.getClass().getPackageName();

		System.out.println("className : " + className);
		System.out.println("packageName : " + packageName);
	}

}
