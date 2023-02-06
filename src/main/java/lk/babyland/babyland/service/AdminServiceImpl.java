package lk.babyland.babyland.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.babyland.babyland.dto.CreateAdminDto;
import lk.babyland.babyland.entity.Admin;
import lk.babyland.babyland.repo.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public Iterable<Admin> allAdmins() {
        return adminRepo.findAll();
    }

    @Override
    public Optional<Admin> getAdminByUsername(String usernameAdmin) {
        return adminRepo.findByUsernameAdmin(usernameAdmin);
    }

    @Override
    public Optional<Admin> saveAdmin(CreateAdminDto admin) {
        
        Optional<Admin> foundAdmin = this.adminRepo.findByUsernameAdmin(admin.getUsernameAdmin());
        
        if(foundAdmin.isPresent()) {
            System.out.println("Username is not available");
            return Optional.empty();

        }
        else{
            Admin newAdmin = new Admin();
            newAdmin.setUsernameAdmin(admin.getUsernameAdmin());
            newAdmin.setEmailAdmin(admin.getEmailAdmin());
            newAdmin.setPasswordAdmin (admin.getPasswordAdmin());
            newAdmin.setRoleAdmin(3);

            return Optional.of(adminRepo.save(newAdmin));
        }
    }
    
}

