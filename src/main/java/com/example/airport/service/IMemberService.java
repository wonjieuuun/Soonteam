package com.example.airport.service;


import com.example.airport.vo.MemVO;

public interface IMemberService {
//	중복검사
	public int memberIdCount(String memId);
//	insert
	public int insertMember(MemVO memVO);
}
