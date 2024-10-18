package com.tns.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUser(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElse(null);
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User updateUser(Long id, User user) {
        if (repository.existsById(id)) {
            user.setId(id);
            return repository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public List<User> getUsersByRole(String role) {
        return repository.findByRole(role);
    }
}
