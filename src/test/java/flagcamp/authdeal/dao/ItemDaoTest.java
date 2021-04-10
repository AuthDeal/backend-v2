package flagcamp.authdeal.dao;


import flagcamp.authdeal.entity.*;
import flagcamp.authdeal.entity.Users.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemDaoTest {
  @Autowired
  ItemDao itemDao;

  @Autowired
  UserDao userDao;

  @Test
  void addItem() {
    Users user1 = new Users("user1", "user1", true, 4.5f,
        "https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png",
        "4251234567", Role.Client);
    userDao.createUsers(user1);

    for (int i = 0; i < 20; i++) {
      Items item = new Items(user1, "Printer", 149.99f,
          "https://www.staples-3p.com/s7/is/image/Staples/sp46466242_sc7?wid=700&hei=700",
          "HP OfficeJet Pro 8210",
          false, ItemCondition.LIKENEW, 98033);
      itemDao.addItem(item);
    }
  }

  @Test
  void deleteItem() {
  }

  @Test
  void findItemById() {
  }

  @Test
  void findAllItems() {
  }

  @Test
  void findItemsBySellId() {
  }
}