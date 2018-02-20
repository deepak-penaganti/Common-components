package com.keystone.common.report;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;


@RunWith(MockitoJUnitRunner.class)
public class UploadReportTest {

	@Test
	public void testUploadReportTest() throws IOException, InterruptedException	{
		Path path = Paths.get("src\\test\\java\\com\\keystone\\common\\report\\test.txt");
		String name = "file.txt";
		String originalFileName = "file.txt";
		String contentType = "text/plain";
		byte[] content = null;
		try {
		    content = Files.readAllBytes(path);
		} catch (final IOException e) {
		}
		MultipartFile file = new MockMultipartFile(name,
		                     originalFileName, contentType, content);
		UploadReport report = new UploadReport();
		ResponseEntity<Object>  res = report.saveUploadedFiles(file);
		String actual = "Successfully uploaded - file.txt";
		Assert.assertEquals(res.getBody().toString(), actual);
	}
}
