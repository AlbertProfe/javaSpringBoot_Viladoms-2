package com.example.employee;

import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Optional;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/apiemployee")
public class EmployeeImagesController {
	
	@Autowired
	EmployeeImagesRepository employeeImagesRepository;
	
	@PostMapping("/createEmployeeImage")
	public EmployeeImages createEmployeeImages (@RequestParam String name, @RequestParam MultipartFile file) throws IOException  {
		
		EmployeeImages employeeImages  = new EmployeeImages();
		employeeImages.setName(name);
		employeeImages.setImage( new Binary(file.getBytes() ));
		
		employeeImagesRepository.save(employeeImages); 
		
		return employeeImages;
	}

	@GetMapping("/getEmployeeImagesData")
	public String getEmployeeImagesData (@RequestParam String id) {
		
		System.out.println("id..." + id);
		Optional<EmployeeImages> employeeImage = employeeImagesRepository.findById(id);
		Encoder encoder = Base64.getEncoder();
		
		return encoder.encodeToString( employeeImage.get().getImage().getData() );
	}
	
	@GetMapping("/getEmployeeImage")
	public ResponseEntity<byte[]> getEmployeeImage (@RequestParam String id) {
		
		Optional<EmployeeImages> employeeImage = employeeImagesRepository.findById(id);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		
		return new ResponseEntity<>( employeeImage.get().getImage().getData(), headers, HttpStatus.OK );
	}	
}
