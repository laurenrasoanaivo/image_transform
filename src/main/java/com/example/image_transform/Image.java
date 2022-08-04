package com.example.image_transform;

import java.io.IOException;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class Image {
    @PostMapping
    @ResponseBody
    public ResponseEntity<?> imagM(@RequestPart("file") MultipartFile file) throws IOException {

        fileStorage.save(file);
        return ResponseEntity.status(HttpStatus.OK).body(byteArrayFile);
    }
    @ResponseBody
    @RequestMapping(value = "/Image/{id:.+}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("id")String id) {
        byte[] image = imageService.getImage(id);  //this just gets the data from a database
        return ResponseEntity.ok(image);
    }
}

