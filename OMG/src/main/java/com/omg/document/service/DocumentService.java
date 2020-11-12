package com.omg.document.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omg.document.dao.DocumentDaoImpl;
import com.omg.document.domain.DocumentVO;

@Service("documentService")
public class DocumentService {

	@Autowired
	DocumentDaoImpl documentDaoImpl;
	
	/**
	 * 문서 ?��?�� 
	 * @param documentVO
	 * @return
	 */
	public int doInsert(DocumentVO documentVO) {
		return documentDaoImpl.doInsert(documentVO);
	}
	
	/**
	 * 문서 ?��?�� 
	 * @param documentVO
	 * @return
	 */
	public int doDelete(DocumentVO documentVO) {
		return documentDaoImpl.doDelete(documentVO);
	}
	
	/**
	 * 문서 갱신
	 * @param documentVO
	 * @return
	 */
	public int doUpdate(DocumentVO documentVO) {
		return documentDaoImpl.doUpdate(documentVO);
	}
	/**
	 * ?���? �??�� 
	 * @param documentVO
	 * @return
	 */
	public DocumentVO doSelectOne(DocumentVO documentVO) {
		return documentDaoImpl.doSelectOne(documentVO);
	}
	
	/**
	 * ?���? �??��
	 * @param documentVO
	 * @return
	 */
	public List<DocumentVO> doSelectList(){
		return documentDaoImpl.doSelectList();
	}
	
	/**
	 * ?���? �??��
	 * @param documentVO
	 * @return
	 */
	
	public List<DocumentVO> doempIdSelectList (DocumentVO documentVO){
		
		return documentDaoImpl.doempIdSelectList(documentVO);
	}
	
	public int doempIdcheck(DocumentVO documentVO) {
		return documentDaoImpl.doempIdcheck(documentVO);
	}

	
}
