package com.iu.home.board.qna;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.util.FileManager;
import com.iu.home.util.Pager;

@Service
public class QnaService {

	@Autowired
	private QnaMapper qnaMapper;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload.qna}")
	private String filePath;
	
	public QnaFileVO getFileDetail(QnaFileVO qnaFileVO) throws Exception {
		return qnaMapper.getFileDetail(qnaFileVO);
	}
	
	public QnaVO getDetail(QnaVO qnaVO) throws Exception {
		return qnaMapper.getDetail(qnaVO);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int setQnaAdd(QnaVO qnaVO, MultipartFile[] files) throws Exception {
		int qnaResult = qnaMapper.setQnaAdd(qnaVO);
		
		File file = new File(filePath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		for(MultipartFile multipartFile : files) {
			
			if(multipartFile.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.saveFile(filePath, multipartFile);
			QnaFileVO qnaFileVO = new QnaFileVO();
			qnaFileVO.setNum(qnaVO.getNum());
			qnaFileVO.setFileName(fileName);
			qnaFileVO.setOriName(multipartFile.getOriginalFilename());
			qnaMapper.setQnaFileAdd(qnaFileVO);
		}
		
		return qnaResult;
	}
	
	public List<QnaVO> getList(Pager pager) throws Exception {
		Long totalCount = qnaMapper.getCount(pager);
		
		pager.getNum(totalCount);
		pager.getRow();
		
		List<QnaVO> list = qnaMapper.getList(pager);
		
		return list;
		
	}
	
}
