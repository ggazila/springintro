package spring.intro.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import spring.intro.dao.UserDao;
import spring.intro.models.User;
import spring.intro.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id);
    }

    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
