package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return Optional.ofNullable(userDao.getUserById(id))
                .orElseThrow(() -> new RuntimeException("Ошибка получения пользователя: пользователя с таким id нет"));
    }

    @Override
    public void deleteUserById(Long id) {
        User user = getUserById(id);
        userDao.deleteUserById(user.getId());
    }

    @Override
    public void updateUser(Long id, User userUpdate) {
        User user = getUserById(id);
        user.setName(userUpdate.getName());
        user.setSurname(userUpdate.getSurname());
        user.setAge(userUpdate.getAge());
        user.setCitizenship(userUpdate.getCitizenship());
        saveUser(user);
    }

}
