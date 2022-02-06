package application.repository;

import application.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<UserModel, Integer>
{
    @Query(value = "SELECT u FROM UserModel u WHERE u.login = :login")
    UserModel getByLogin(@Param("login") String login);

    @Modifying
    @Transactional
    @Query(value = "UPDATE UserModel u SET u.login= :login_to_set," +
            "u.password= :password_to_set WHERE u.login= :login_to_identify")
    void updateUser(@Param("login_to_set") String setLogin ,
                    @Param("password_to_set") String password ,
                    @Param("login_to_identify") String oldLogin);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM UserModel u WHERE u.login = :login")
    void deleteUser(@Param("login") String login);
}