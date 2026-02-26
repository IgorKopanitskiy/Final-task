package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return Optional.ofNullable(userDao.getUserById(id))
                .orElseThrow(() -> new RuntimeException("Ошибка получения пользователя: пользователя с таким id нет"));
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        User user = userDao.getUserById(id);
        if (user != null) {
            userDao.deleteUser(user);
        }
    }

    @Override
    @Transactional
    public void updateUser(Long id, User userUpdate) {
        User user = getUserById(id);
        user.setName(userUpdate.getName());
        user.setSurname(userUpdate.getSurname());
        user.setAge(userUpdate.getAge());
        user.setCitizenship(userUpdate.getCitizenship());
        saveUser(user);
    }
}
