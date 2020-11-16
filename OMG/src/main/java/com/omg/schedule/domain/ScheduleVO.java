package com.omg.schedule.domain;

import com.omg.cmn.Criteria;
import com.omg.cmn.PageDTO;

public class ScheduleVO extends PageDTO {
	
    private int schedule_no;	//일정번호
    private int dept_no;	//부서번호
    private String employee_id;	//사원번호
    private int category_id;	//카테고리ID
    private String category_nm;	//카테고리 이름
    private String title;	//제목
    private String content;	//내용
    private String start_dt;	//시작일
    private String end_dt;	//종료일
    
	public ScheduleVO() {
		super();
		this.category_id = 1;
	}
	
    public ScheduleVO(Criteria cri, int total, int schedule_no, int dept_no, String employee_id, int category_id,
			String category_nm, String title, String content, String start_dt, String end_dt) {
		super(cri, total);
		this.schedule_no = schedule_no;
		this.dept_no = dept_no;
		this.employee_id = employee_id;
		this.category_id = category_id;
		this.category_nm = category_nm;
		this.title = title;
		this.content = content;
		this.start_dt = start_dt;
		this.end_dt = end_dt;
	}



	public int getSchedule_no() {
        return schedule_no;
    }

    public void setSchedule_no(int schedule_no) {
        this.schedule_no = schedule_no;
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_nm() {
        return category_nm;
    }

    public void setCategory_nm(String category_nm) {
        this.category_nm = category_nm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStart_dt() {
        return start_dt;
    }

    public void setStart_dt(String start_dt) {
        this.start_dt = start_dt;
    }

    public String getEnd_dt() {
        return end_dt;
    }

    public void setEnd_dt(String end_dt) {
        this.end_dt = end_dt;
    }

    @Override
    public String toString() {
	return "ScheduleVO [schedule_no=" + schedule_no + ", dept_no=" + dept_no + ", employee_id=" + employee_id
		+ ", category_id=" + category_id + ", category_nm=" + category_nm + ", title=" + title + ", content="
		+ content + ", start_dt=" + start_dt + ", end_dt=" + end_dt + "]";
    }

}
