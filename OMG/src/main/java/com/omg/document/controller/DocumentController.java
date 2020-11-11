package com.omg.document.controller;


import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.google.gson.Gson;
import com.omg.cmn.Message;
import com.omg.document.domain.DocumentVO;
import com.omg.document.service.DocumentService;




@Controller
public class DocumentController {
	final Logger  LOG = LoggerFactory.getLogger(DocumentController.class);
	
	@Autowired
	DocumentService documentService; 
	
	@Autowired
	MessageSource messageSource;
	
	String url = "http://localhost:8080/cmn";
	//--view--
	
	//--?���? 문서 목록 page
	@RequestMapping(value="document/document.do", method = RequestMethod.GET )
	public String document_view(DocumentVO documentVO, Model  model){
		model.addAttribute("url", url);
		
		documentVO.setEmployeeId("ID01");
		
		List<DocumentVO> IdSeleteList = documentService.doempIdSelectList(documentVO);
		model.addAttribute("IdSeleteList", IdSeleteList);
		model.addAttribute("IdSeleteSize", IdSeleteList.size());
		
		LOG.debug("=IdSeleteList="+IdSeleteList);
		
		
		
		return  "document/document";
	}
	
	//--문서 ?���? page
	@RequestMapping(value="document/document_reg.do", method = RequestMethod.GET )
	public String document_reg(){
		LOG.debug("===========================");
		LOG.debug("=document_reg.do=");
		LOG.debug("===========================");
		return "document/document_reg";
	}
	
	//--문서 ?��?�� ?���? page
	@RequestMapping(value="document/document_info.do", method = RequestMethod.GET )
	public String document_info(DocumentVO documentVO, Model  model){
		
		
		//String Id = "ID02";
		documentVO.setDocumentId("E_0001");
		documentVO.setEmployeeId("ID02");
		
		
		
		List<DocumentVO> one = documentService.doempIdSelectList(documentVO);
	
		DocumentVO voList = one.get(0);
		
		model.addAttribute("one", voList);
		model.addAttribute("title", (voList.getTitle()));
		model.addAttribute("kind", (voList.getKind()));
		model.addAttribute("dDay", (voList.getdDay()));
		model.addAttribute("okUser", (voList.getOkUser()));
		model.addAttribute("cont", (voList.getDocumentCont()));
		
		
		// .get -> 0 ?���? if(){ .set}
		// .set(pk�?)(StringUtil.nvl( .get(pk�?),""))
		//
		//model.addAttribute("",VO)
		//?��비스 ?���? 
		//List<VO> document = this.Service.doSeleteOne(VO);
		//�? ?��?�� 
		//model.addAttribute("name�?", ?��?��?��  ) <?��면으�? ?��?��?��?�� 보내�?> 
		
		//jsp file ?��?��?�� ${model name�? ?��?�� }
		
		String view = "document/document_info";
		
		return view;
	}
	
	
	
	//--기능----------------------------------------------------------------------------- 
	
	//--?���? �??��
	@RequestMapping(value="document/doSelectOne.do",method = RequestMethod.GET ,produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String doSelectOne(DocumentVO documentVO) {
        LOG.debug("==================");
        LOG.debug("=documentVO="+documentVO);
        LOG.debug("==================");		
        
        //documentVO.setDocumentId("E_0001");
        DocumentVO outVO =documentService.doSelectOne(documentVO);
        
        LOG.debug("==================");
        LOG.debug("=doSelectOne="+outVO);
        LOG.debug("==================");
        
        Gson gson=new Gson();
        String json = gson.toJson(outVO);
        LOG.debug("==================");
        LOG.debug("=json="+json);
        LOG.debug("==================");
         
        return json;
	}
	//-- ?���? �??��
	@RequestMapping(value="document/doSelectList.do",method = RequestMethod.GET ,produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String doSelectList(DocumentVO documentVO) {
        LOG.debug("==================");
        LOG.debug("=documentVO="+documentVO);
        LOG.debug("==================");		
        
        //documentVO.setDocumentId("E_0001");
        List<DocumentVO> outVO =documentService.doSelectList();
        
        LOG.debug("==================");
        LOG.debug("=doSelectList="+outVO);
        LOG.debug("==================");
        
        Gson gson=new Gson();
        String json = gson.toJson(outVO);
        LOG.debug("==================");
        LOG.debug("=json="+json);
        LOG.debug("==================");
         
        return json;
	}
	//-- ?���? 기�? �??��
	@RequestMapping(value="document/doempIdSelectList.do",method = RequestMethod.GET ,produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String doempIdSelectList(DocumentVO documentVO) {
        LOG.debug("==================");
        LOG.debug("=documentVO="+documentVO);
        LOG.debug("==================");		
        
        //documentVO.setDocumentId("E_0001");
        List<DocumentVO> outVO =documentService.doempIdSelectList(documentVO);
        
        LOG.debug("==================");
        LOG.debug("=doempIdSelectList="+outVO);
        LOG.debug("==================");
        
        Gson gson=new Gson();
        String json = gson.toJson(outVO);
        LOG.debug("==================");
        LOG.debug("=json="+json);
        LOG.debug("==================");
         
        return json;
	}
	
	
	
	//-- ?���?
	@RequestMapping(value="document/doInsert.do",method = RequestMethod.GET ,produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String doInsert(DocumentVO documentVO) {
        LOG.debug("==================");
        LOG.debug("=documentVO="+documentVO);
        LOG.debug("==================");		
        
        //documentVO.setDocumentId("E_0001");
        int flag =documentService.doInsert(documentVO);
        
        LOG.debug("=doInsert="+flag);
        Message  message=new Message();
        message.setMsgId(flag+"");
        
        if(flag ==1 ) {
        	message.setMsgContents(documentVO.getTitle()+"문서�? ?��록되?��?��?��?��.");
        }else {
        	message.setMsgContents(documentVO.getTitle()+"문서�? ?��록실?��?��?��?��?��?��.");
        }
        
        Gson gson=new Gson();
        String json = gson.toJson(message);
        LOG.debug("==================");
        LOG.debug("=json="+json);
        LOG.debug("==================");         
        
        return json;
	}
	
	//-- ?��?��
	@RequestMapping(value="document/doDelete.do",method = RequestMethod.GET ,produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String doDelete(DocumentVO documentVO) {
        LOG.debug("==================");
        LOG.debug("=documentVO="+documentVO);
        LOG.debug("==================");		
        
        //documentVO.setDocumentId("E_0001");
        int flag =documentService.doDelete(documentVO);
        
        LOG.debug("=doDelete="+flag);
        Message  message=new Message();
        message.setMsgId(flag+"");
        
        if(flag ==1 ) {
        	message.setMsgContents(documentVO.getTitle()+"문서�? ?��?��?��?��?��?��?��.");
        }else {
        	message.setMsgContents(documentVO.getTitle()+"문서�? ?��?�� ?��?��?��?��?��?��?��.");
        }
        
        Gson gson=new Gson();
        String json = gson.toJson(message);
        LOG.debug("==================");
        LOG.debug("=json="+json);
        LOG.debug("==================");         
        
        return json;
	}
	
	//-- ?��?�� 
	@RequestMapping(value="document/doUpdate.do",method = RequestMethod.GET ,produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String doUpdate(DocumentVO documentVO) {
        LOG.debug("==================");
        LOG.debug("=documentVO="+documentVO);
        LOG.debug("==================");		
        
        //documentVO.setDocumentId("E_0001");
        int flag =documentService.doUpdate(documentVO);
        
        LOG.debug("=doInsert="+flag);
        Message  message=new Message();
        message.setMsgId(flag+"");
        
        if(flag ==1 ) {
        	message.setMsgContents(documentVO.getTitle()+"문서�? ?��?��?��?��?��?��?��.");
        }else {
        	message.setMsgContents(documentVO.getTitle()+"문서�? ?��?�� ?��?��?��?��?��?��?��.");
        }
        
        Gson gson=new Gson();
        String json = gson.toJson(message);
        LOG.debug("==================");
        LOG.debug("=json="+json);
        LOG.debug("==================");         
        
        return json;
	}



	
}
	

