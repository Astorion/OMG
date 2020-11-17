package com.omg.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.omg.board.domain.BoardVO;
import com.omg.board.service.BoardService;
import com.omg.cmn.Search;
import com.omg.code.dao.CodeDaoImpl;
import com.omg.employee.domain.EmployeeVO;

@Controller
public class MainController {
	final Logger LOG = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	CodeDaoImpl codeDaoImpl;
	
	@RequestMapping(value="view/main.do",method=RequestMethod.GET)
	public String main_view() {
		LOG.debug("== main ==");
		
		return "index";
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String startPage() {
		LOG.debug("== main ==");
		
		return "index";
	} 
	
	@RequestMapping(value="view/blank.do",method=RequestMethod.GET)
	public String blank_view() {
		LOG.debug("== user_view ==");
		
		return "blank";
	}
	
	@RequestMapping(value="view/main2.do",method=RequestMethod.GET)
	public String main2_view(HttpServletRequest req,Search search,Model model) {
		LOG.debug("== main2_view ==");
		
		//1. 세션 GET
		HttpSession session = req.getSession();
		EmployeeVO sessionVO = (EmployeeVO) session.getAttribute("employee");
		
		//2. 내 부서 게시판 불러오기
		List<BoardVO> deptBoardList = this.boardService.doSelectList(new Search("20", 5, 1));
		model.addAttribute("deptBoardList", deptBoardList);
		
		
		//3. 공지사항 게시판 불러오기
		List<BoardVO> noticeList = this.boardService.doSelectList(new Search("10",5,1));
		model.addAttribute("noticeList", noticeList);
		//3. 내 부서 스케줄 불러오기
		
		return "index2";
	}
	

}
