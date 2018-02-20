package com.keystone.common.report;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;

public class DownloadReport {
	/**
	 * Logger for DownloadReport
	 */
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**This method is used to fetch the file from database/from a specific location
	 * @param fileName Name of the file to be downloaded
	 * @return ResponseEntity the returned file with status
	 * @throws IOException Exception thrown while  fetching the file
	 */
	public ResponseEntity downloadReport(String fileName) throws IOException {
		File fileToDownload = new File(fileName);

		Path path = Paths.get(fileToDownload.getAbsolutePath());
		log.debug("Path of file: " + path);
		log.debug("File name: " + fileToDownload.getName());
		ByteArrayResource resource = null;

		resource = new ByteArrayResource(Files.readAllBytes(path));

		return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=" + fileToDownload.getName())
				.contentLength(fileToDownload.length()).body(resource);
	}

}
