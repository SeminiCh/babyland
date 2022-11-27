package lk.babyland.babyland.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lk.babyland.babyland.service.AgentPhotoService;

@CrossOrigin
@Controller
@RequestMapping("/api/v1/agentPhoto")
public class AgentPhotoController {
    @Autowired
    private AgentPhotoService agentPhotoService;

    @PostMapping("savePhoto")
    public ResponseEntity<?> saveAgentPhoto (@RequestParam("image") MultipartFile apImagFile) throws IOException{
        String uploadImage = Service.saveAgent(apImagFile);
        return ResponseEntity.status(HttpStatus.OK)
        .body(uploadImage);
    }
}

