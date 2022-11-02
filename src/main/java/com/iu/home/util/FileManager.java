package com.iu.home.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.home.board.qna.QnaFileVO;

@Component
public class FileManager extends AbstractView {
	
	@Value("${app.download.base}")
	private String fileDownBasePath;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String path = model.get("path").toString();
		
		if(path.equals("qna")) {
			QnaFileVO qnaFileVO = (QnaFileVO)model.get("fileVO");
			
			File file = new File(fileDownBasePath + path, qnaFileVO.getFileName());
			
			response.setCharacterEncoding("UTF-8");
			response.setContentLengthLong(file.length());
			
			String oriName = URLEncoder.encode(qnaFileVO.getOriName(), "UTF-8");
			
			response.setHeader("Content-Disposition", "attachment;filename=\""+oriName+"\"");
			response.setHeader("Content-Transfer-Encoding", "binary");
			
			FileInputStream fi = new FileInputStream(file);
			OutputStream os = response.getOutputStream();
			
			FileCopyUtils.copy(fi, os);
			
			os.close();
			fi.close();
		}
		
	}
	
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
