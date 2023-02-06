package lk.babyland.babyland.repo;

import lk.babyland.babyland.entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository

public interface AdminRepo extends CrudRepository <Admin, Long> {
    Optional<Admin> findByUsernameAdmin (final String usernameAdmin);
    Optional <Admin> findByUsernameAdminAndPasswordAdmin(String usernameAdmin, String passwordAdmin);
    
}
