package flagcamp.authdeal.controller;

import flagcamp.authdeal.dao.*;
import flagcamp.authdeal.entity.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

  @Autowired
  private UserDao userDao;

  @RequestMapping(value = "/users/all", method = RequestMethod.GET)
  public List<Users> fetchAllUsers() {
    return userDao.findAllUsers();
  }

}
