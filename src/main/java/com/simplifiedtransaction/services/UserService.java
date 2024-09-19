package com.simplifiedtransaction.services;

import com.simplifiedtransaction.domain.UserType;
import com.simplifiedtransaction.domain.user.User;
import com.simplifiedtransaction.dtos.UserDTO;
import com.simplifiedtransaction.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuario do Tipo Logista Não está Auturizado a realizar Transação!`");
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Saldo Insuficiente!");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuario Não Encontrado!"));
    }

    public User createUSer(UserDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers() { return this.repository.findAll(); }

    public void saveUser(User user) { this.repository.save(user); }
}
