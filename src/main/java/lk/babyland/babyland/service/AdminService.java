package lk.babyland.babyland.service;

import lk.babyland.babyland.dto.CreateAdminDto;
import lk.babyland.babyland.entity.Admin;
import java.util.Optional;

public interface AdminService {
    Iterable<Admin> allAdmins();

    Optional<Admin> getAdminByUsername(final String usernameAdmin);

    Optional<Admin> saveAdmin(final CreateAdminDto admin);
    
}
