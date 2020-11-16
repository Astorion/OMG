package com.omg.schedule.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.omg.cmn.Criteria;
import com.omg.cmn.PageDTO;
import com.omg.schedule.domain.ScheduleVO;
import com.omg.schedule.service.ScheduleService;

@Controller
@RequestMapping("/schedule/*")
public class ScheduleController {

	Logger log = LoggerFactory.getLogger(ScheduleController.class);

	@Autowired
	private ScheduleService service;


	/**
	 * 일정 추가
	 * 
	 * @param inVO
	 * @param rttr
	 * @author 박정민
	 */
	@RequestMapping(value = "/doInsert.do", method = RequestMethod.POST)
	public String doInsert(ScheduleVO inVO, RedirectAttributes rttr) {
		
		log.debug("[Insert]ScheduleVO: " + inVO);
		int flag = service.doInsert(inVO);
		
		rttr.addFlashAttribute("result", flag);

		return "redirect:/schedule/doSelectList.do"; // 생성 완료되면 일정관리 페이지로 리다이렉트
	}

	@RequestMapping(value = "/doInsert.do", method = RequestMethod.GET)
	public void insert() {

	}

	/**
	 * 일정 삭제
	 * 
	 * @param scheduleNo
	 * @param rttr
	 * @author 박정민
	 */
	@RequestMapping(value = "/doDelete.do", method = RequestMethod.POST)
	public String doDelete(@RequestParam("schedule_no") int schedule_no, RedirectAttributes rttr) {
		log.debug("[Delete]scheduleNo: " + schedule_no);

		ScheduleVO inVO = new ScheduleVO();
		inVO.setSchedule_no(schedule_no);

		if (service.doDelete(inVO) == 1) {
			rttr.addFlashAttribute("result", "success");
		}

		return "redirect:/schedule/doSelectList.do";
	}

	/**
	 * 일정 수정
	 * 
	 * @param inVO
	 * @param rttr
	 * @author 박정민
	 */
	@RequestMapping(value = "/doUpdate.do", method = RequestMethod.POST)
	public String doUpdate(ScheduleVO inVO, RedirectAttributes rttr) {
		log.debug("doUpdate loading.....");
		log.debug("[Update]ScheduleVO: " + inVO);

		if (service.doUpdate(inVO) == 1) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/schedule/doSelectList.do";
	}

	/**
	 * 일정 선택
	 * 
	 * @param scheduleNo
	 * @param model
	 * @author 박정민
	 */
	@RequestMapping(value = { "/doSelectOne.do", "/doUpdate.do" }, method = RequestMethod.GET)
	public void doSelectOne(@RequestParam("schedule_no") int schedule_no, Criteria cri, Model model) {
		log.debug("doSelectOne or doUpdate.....");

		ScheduleVO inVO = new ScheduleVO();
		inVO.setSchedule_no(schedule_no);

		ScheduleVO outVO = service.doSelectOne(inVO);
				
		outVO.setStart_dt(outVO.getStart_dt().replace(" ", "T"));
		outVO.setEnd_dt(outVO.getEnd_dt().replace(" ", "T"));
		
		model.addAttribute("schedule", outVO);
		model.addAttribute("cri", cri);
	}

	/**
	 * 
	 * 일정 검색 deptNo: 0(전체검색) or 부서별검색
	 * 
	 * @param deptNo
	 * @param model
	 * @author 박정민
	 */
	@RequestMapping(value = "/doSelectList.do", method = RequestMethod.GET)
	public void doSelectList(Criteria cri, Model model) {
		log.debug("doSelectList loading.....");
		log.debug("doSelectList: " + cri);

		int total = service.getTotalCount(cri);
		
		model.addAttribute("list", service.doSelectList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		
		log.debug("doSelectList complite.....");
	}
}
