package com.test.test.Services;

import com.test.test.Entities.Document;
import com.test.test.Repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    @Value("${filePath}")
    private String basePath;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public String uploadDocument (String title, MultipartFile multipartFile){
        File dir = new File(basePath);
        if (!dir.exists()){
            dir.mkdirs();
        }
        Path path = Path.of(basePath + File.separator + title);
        if(Files.exists(path)){
            return "Exist";
        }
        try{
            multipartFile.transferTo(path.toFile());

            Document document =new Document();
            document.setTitle(title);
            document.setDocumentType(multipartFile.getContentType());
            documentRepository.save(document);
            return "CREATED";
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "FAILED";
        }
    }
}
