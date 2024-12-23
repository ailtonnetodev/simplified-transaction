package com.simplifiedtransaction.repositories;

import com.simplifiedtransaction.domain.UserType;
import com.simplifiedtransaction.domain.user.User;
import com.simplifiedtransaction.dtos.UserDTO;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("Shold get User Sucessfully from DB")
    void findUserByDocumentCase1() {
        String document = "99999999901";
        UserDTO data = new UserDTO("Ailton", "Neto", document, new BigDecimal(10), "test@gmail.com", "33333", UserType.COMMON);
        this.createUser(data);

        Optional<User> result = this.userRepository.findUserByDocument(document);

        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Shold not get User from DB when user not exists")
    void findUserByDocumentCase2() {
        String document = "99999999901";
        Optional<User> result = this.userRepository.findUserByDocument(document);
        assertThat(result.isEmpty()).isTrue();
    }

    private User createUser (UserDTO data) {
        User newUser = new User(data);
        this.entityManager.persist(newUser);
        return newUser;
    }
}