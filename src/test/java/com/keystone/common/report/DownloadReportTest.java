package com.keystone.common.report;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class DownloadReportTest {
	
	@Test
	public void testDownloadReportTest() throws IOException {
		DownloadReport report = new DownloadReport();
		ResponseEntity entity = report.downloadReport("src\\test\\java\\com\\keystone\\common\\report\\test.txt");
		ByteArrayResource resource = (ByteArrayResource) entity.getBody();
		String value = new String(resource.getByteArray());
		String actual = "This is a test file";
		Assert.assertEquals(value,actual);
		
	}

}
