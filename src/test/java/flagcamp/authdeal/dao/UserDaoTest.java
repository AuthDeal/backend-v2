package flagcamp.authdeal.dao;

import static org.junit.jupiter.api.Assertions.*;

import flagcamp.authdeal.entity.Users;
import flagcamp.authdeal.entity.Users.Role;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserDaoTest {
  @Autowired
  UserDao userDao;

  @Test
  void createUsers() {
    System.out.println("Hello world!");
    Users user2 = new Users("user2", "user2", true, 4.5f, "picture", "4251234567", Role.Client);
    userDao.createUsers(user2);
    System.out.println(user2.toString());
  }

  @Test
  void findUserById() {
    Users result = userDao.findUserById("anson@authdeal.com");
    System.out.println(result.toString());
    System.out.println();
    System.out.println(userDao.findUserById("anson2@authdeal.com").toString());
  }

  @Test
  void findAllUsers() {
    List<Users> result = userDao.findAllUsers();
    for (Users user : result) {
      System.out.println(user.toString());
    }
  }
}