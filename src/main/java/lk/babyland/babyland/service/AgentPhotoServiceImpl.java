package lk.babyland.babyland.service;

import java.util.Optional;
import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.multipart.MultipartFile;

import lk.babyland.babyland.entity.AgentPhoto;
import lk.babyland.babyland.repo.AgentPhotoRepo;

public class AgentPhotoServiceImpl {
    @Autowired
    private AgentPhotoRepo agentPhotoRepo;

    private final String FOLDERPATH = "D:\BabyLandFolder";

    public String saveAgentPhoto(MultipartFile apImage) throws IOException{
    String filepath = FOLDERPATH+apImage.getOriginalFilename();
        AgentPhoto agentPhoto = agentPhotoRepo.save(AgentPhoto.builder()
        .apName(apImage.getOriginalFilename())
        .filePath(filepath).build()
        );
        
        apImage.transferTo(new File(filepath));
        if (agentPhoto != null){
            return "file Uploaded :"+ filepath;
        }

        return null;

    }

    
}
