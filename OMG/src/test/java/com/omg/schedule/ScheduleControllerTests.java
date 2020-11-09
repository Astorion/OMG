package com.omg.schedule;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		       "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class ScheduleControllerTests {
    final Logger LOG = Logger.getLogger(ScheduleControllerTests.class);
    @Autowired
    private WebApplicationContext ctx;
    
    private MockMvc mockMvc;

    @Before
    public void setup() {
	this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    /**
     * 일정 등록 테스트
     * @throws Exception
     * @author 박정민
     */
    @Test
    @Ignore
    public void testInsert() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/schedule/insert.do")
			.param("deptNo", "10")
			.param("employeeId", "Test_User")
			.param("categoryId", "10")
			.param("timeStatus", "0")
			.param("title", "테스트 제목")
			.param("content", "테스트 내용")
			.param("startDt", "2020-01-01 00:00")
			.param("endDt", "2020-01-01 00:00")
			).andReturn().getModelAndView().getViewName();
		
		LOG.debug(resultPage);
    }
    
    /**
     * 일정 삭제 테스트
     * @throws Exception
     * @author 박정민
     */
    @Test
    @Ignore
    public void testDelete() throws Exception {
    	String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/schedule/delete.do")
    		.param("scheduleNo", "37")
    		).andReturn().getModelAndView().getViewName();
    	
    	LOG.debug(resultPage);
    }
    
    /**
     * 일정 수정 테스트
     * @throws Exception
     * @author 박정민
     */
    @Test
    public void testUpdate() throws Exception {
    	String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/schedule/update.do")
    		.param("categoryId", "10")
    		.param("timeStatus", "0")
    		.param("title", "테스트 제목")
    		.param("content", "테스트 내용")
    		.param("startDt", "2020-11-09")
    		.param("endDt", "2020-11-09")
    		.param("scheduleNo", "47")
    		).andReturn().getModelAndView().getViewName();
    	
    	LOG.debug(resultPage);
    }
    
    /**
     * 일정 선택 테스트
     * @throws Exception
     * @author 박정민
     */
    @Test
    public void testSelectOne() throws Exception {
    	String resultPage = mockMvc.perform(MockMvcRequestBuilders.get("/schedule/get.do")
    		.param("scheduleNo", "47")
    		).andReturn().getModelAndView().getViewName();
    	
    	LOG.debug(resultPage);
    }
    
    /**
     * 일정 목록화 테스트
     * depNo = 0(전체검색)
     * @throws Exception
     * @author 박정민
     */
    @Test
    public void testList() throws Exception {
		LOG.debug(mockMvc.perform(MockMvcRequestBuilders.get("/schedule/list.do")
			.param("deptNo", "0")
			).andReturn().getModelAndView().getModelMap());
    }
    
}
