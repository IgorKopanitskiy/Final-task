package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UseDaoImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(Long id) {
        User user = entityManager.find(User.class, id);
        if (user!= null) {
            return user;
        } else {
            throw new RuntimeException("Ошибка получения пользователя: пользователя с таким id нет");
        }
    }

    @Override
    public void deleteUser(Long id) {
        try {
            User user = getUser(id);
            entityManager.remove(user);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateUser(Long id, User userUpdate) {
        try {
            User user = getUser(id);
            user.setName(userUpdate.getName());
            user.setSurname(userUpdate.getSurname());
            user.setAge(userUpdate.getAge());
            user.setCitizenship(userUpdate.getCitizenship());
            saveUser(user);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
