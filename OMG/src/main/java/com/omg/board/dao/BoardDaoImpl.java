package com.omg.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omg.board.domain.BoardVO;
import com.omg.cmn.Search;

@Repository("BoardDao")
public class BoardDaoImpl implements BoardDao
{
	final static Logger LOG = LoggerFactory.getLogger(BoardDaoImpl.class);
	
	
	/** NAMESPACE */
	private final String NAMESPACE = "com.omg.board";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	public BoardDaoImpl() {}
	
	@Override
	public List<BoardVO> doSelectList(Search search)
	{
		LOG.debug("===========================");
		LOG.debug("=doSelectList=");
		LOG.debug("===========================");
		
		String statement = NAMESPACE + ".doSelectList";
		LOG.debug("===========================");
		LOG.debug("=statement : "+statement);
		LOG.debug("=param : "+search);
		LOG.debug("===========================");
		
		List<BoardVO> list = this.sqlSessionTemplate.selectList(statement, search);
		
		for(BoardVO vo : list)
		{
			LOG.debug("vo : "+vo);
		}
		
		return list;
	}
	
	@Override
	public BoardVO doSelectOne(BoardVO boardVO)
	{
		LOG.debug("===========================");
		LOG.debug("=doSelectOne=");
		LOG.debug("===========================");
		
		String statement = NAMESPACE + ".doSelectOne";
		LOG.debug("===========================");
		LOG.debug("=statement : "+statement);
		LOG.debug("=boardVO : "+boardVO);
		LOG.debug("===========================");
		
		BoardVO outVO = this.sqlSessionTemplate.selectOne(statement, boardVO);
		
		return outVO;
	}
	
	@Override
	public int doUpdate(BoardVO boardVO)
	{
		LOG.debug("===========================");
		LOG.debug("=doUpdate=");
		LOG.debug("===========================");
		
		String statement = NAMESPACE + ".doUpdate";
		LOG.debug("===========================");
		LOG.debug("=statement : "+statement);
		LOG.debug("=boardVO : "+boardVO);
		LOG.debug("===========================");
		
		int flag = sqlSessionTemplate.update(statement, boardVO);
		
		return flag;
	}
	
	@Override
	public int doDelete(BoardVO boardVO)
	{
		LOG.debug("===========================");
		LOG.debug("=doDelete=");
		LOG.debug("===========================");
		
		String statement = NAMESPACE + ".doDelete";
		LOG.debug("===========================");
		LOG.debug("=statement : "+statement);
		LOG.debug("=boardVO : "+boardVO);
		LOG.debug("===========================");
		
		int flag = sqlSessionTemplate.delete(statement, boardVO);
		LOG.debug("=flag : "+flag);
		
		return flag;
	}
	
	/**
	 * 게시판 등록
	 * @param board
	 * @return
	 */
	@Override
	public int doInsert(BoardVO boardVO)
	{
		LOG.debug("===========================");
		LOG.debug("=doInsert=");
		LOG.debug("===========================");
		
		String statement = NAMESPACE + ".doInsert";
		LOG.debug("===========================");
		LOG.debug("=statement : "+statement);
		LOG.debug("=boardVO : "+boardVO);
		LOG.debug("===========================");
		
		int flag = sqlSessionTemplate.insert(statement, boardVO);
		
		return flag;
	}
}
