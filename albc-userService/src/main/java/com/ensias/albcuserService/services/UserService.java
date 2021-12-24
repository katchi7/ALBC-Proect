package com.ensias.albcuserService.services;

import com.ensias.albcuserService.exceptions.UserServiceException;
import com.ensias.albcuserService.model.User;
import com.ensias.albcuserService.repos.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
    public User getUserById(Long id){
        User user = userRepo.findById(id).orElse(null);
        if(user==null) throw new UserServiceException(HttpStatus.NOT_FOUND,"User with id "+id+" not found");
        return user;
    }
    public void  updateUserPassword(Long id ,String oldPassword,String newPassword ){
        User user = getUserById(id);
        if(passwordEncoder.matches(oldPassword,user.getPassword())){
            user.setPassword(passwordEncoder.encode(oldPassword));
            userRepo.save(user);
        }else {
            throw new UserServiceException(HttpStatus.UNAUTHORIZED,"Password is not correct");
        }
    }
    public User validateUserNamePassword(String login,String password){
        List<User> users = userRepo.findUserByLogin(login);
        User user;
        if(users.size() == 1){
             user = users.get(0);
            if(!passwordEncoder.matches(password, user.getPassword())) throw new UserServiceException(HttpStatus.UNAUTHORIZED,"Password is incorrect");
        }
        else {
            throw new UserServiceException(HttpStatus.UNAUTHORIZED,"an error occurred");
        }

        return user;
    }
    public User findUserBLogin(String login){
        List<User> users = userRepo.findUserByLogin(login);
        if(users.size()==1){
            return users.get(0);
        }
        throw new UserServiceException(HttpStatus.UNAUTHORIZED,"an error occurred");
    }
    public List<User> findOtherUsers(Long userId){
        return userRepo.findOthers(userId);
    }
}
