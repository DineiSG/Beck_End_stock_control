package com.autoshopping.stock_control.api.user;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;



public interface UsersRepository extends CrudRepository<Users, String> {

    Optional<Users> getUsersById(Integer id);

}
