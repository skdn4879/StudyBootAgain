package com.iu.home.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	public String saveFile(String path, MultipartFile multipartFile) throws Exception {
		
		String fileName = UUID.randomUUID().toString();
		
		StringBuffer bf = new StringBuffer();
		bf.append(fileName);
		
		String ex = multipartFile.getOriginalFilename();
		ex = ex.substring(ex.lastIndexOf("."));
		
		bf.append(ex);
		
		fileName = bf.toString();
		
		File file = new File(path, fileName);
		
		multipartFile.transferTo(file);
		
		return fileName;
		
	}
	
}
