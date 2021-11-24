package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.UserModel;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    public String encrypt(String password);
    List<UserModel> findAll();
    UserModel getUserByUsername(String username);
    void deleteUser(UserModel username);
    List<UserModel> getListUserByEmail(String email);
}
