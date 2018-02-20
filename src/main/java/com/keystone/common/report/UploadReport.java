package com.keystone.common.report;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public class UploadReport {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**This method is used to save the file 
	 * @return ResponseEntity The response status
	 * @param uploadfile the name of the file to be uploaded
	 * @throws IOException exception thrown while saving the file
	 * @author rishkumar
	 * @throws InterruptedException 
	 */
	public ResponseEntity<Object> saveUploadedFiles(MultipartFile uploadfile) throws IOException, InterruptedException {

		byte[] bytes = uploadfile.getBytes();

		Path path = Paths.get(uploadfile.getOriginalFilename());
		Files.write(path, bytes);
				
        log.info("File saved successfully!");
        ResponseEntity<Object> fileUploadResponse = new ResponseEntity<Object>("Successfully uploaded - " + uploadfile.getOriginalFilename(),
 				new HttpHeaders(), HttpStatus.OK);
        return fileUploadResponse;
	}

}
