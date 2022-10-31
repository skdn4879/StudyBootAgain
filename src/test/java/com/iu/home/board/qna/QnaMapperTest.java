package com.iu.home.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QnaMapperTest {

	@Autowired
	private QnaMapper qnaMapper;
	
	/*@Test
	void test() {
		fail("Not yet implemented");
	}*/
	
	/*@Test
	void insertTest() {
		int count = 0;
		for(int i = 1; i <= 50; i++) {
			QnaVO qnaVO = new QnaVO();
			qnaVO.setWriter("writer" + i);
			qnaVO.setTitle("title" + i);
			qnaVO.setContents("contents" + i);
			try {
				qnaMapper.setQnaAdd(qnaVO);
			} catch (Exception e) {
				e.printStackTrace();
			}
			count++;
		}
		assertEquals(50, count);
	}*/

}
