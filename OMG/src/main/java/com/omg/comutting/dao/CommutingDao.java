package com.omg.comutting.dao;

import java.util.List;

import com.omg.cmn.DTO;
import com.omg.cmn.Search;
import com.omg.commuting.domain.Commuting;

public interface CommutingDao {
	
	/**
	 * 로그?��?�� 기본 row ?��?��
	 * @param dto
	 * @return
	 * @author ?��광�??
	 */
	public int doInsert(DTO dto);
	
	/**
	 * 출근,?���? ?���?
	 * @param dto
	 * @return ?���?(1), ?��?��(0)
	 * @author ?��광�??
	 */
	public int doUpdate(DTO dto);
	
	/**
	 * row ?��?��
	 * @param dto
	 * @return ?���?(1), ?��?��(0)
	 * @author ?��광�??
	 */
	public int doDelete(DTO dto);
	
	/**
	 * 금일 본인 ?���? select
	 * @param dto
	 * @return DTO
	 * @author ?��광�??
	 */
	public DTO doSelectOne(DTO dto);
	
	/**
	 * ?��짜별 , �??���?
	 * @param search
	 * @return List<Commuting>
	 * ?��광�??
	 */
	public List<Commuting> doSelectList(Search search);
	
	/**
	 * �� �ٹ���Ȳ
	 * @param search
	 * @return List<Commuting>
	 * �籤��
	 */
	public List<Commuting> doSelectMyList(DTO dto);
	
	/**
	 * ?�� 근무?��?��
	 * @param search
	 * @return List<Commuting>
	 * ?��광�??
	 */
	public List<Commuting> doSelectMyList(DTO dto);
	
	/**
	 * ?���? 기본 ?��?�� insert
	 * @return ?���?(1), ?��?��(0)
	 * ?��광�??
	 */
	public int doInit();
	
	/**
	 * 근무?���? update
	 * @param dto
	 * @return ?���?(1), ?��?��(0)
	 * ?��광�??
	 */
	public int doUpdateWorkTime(DTO dto);
	
	
	
}
