package com.example.demo.entity;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class P_HospitalPaging {
	private int cpage;
	private int recordPerPage;
	private int blockPerPage;
	private int totalPage;
	private int totalRecord;
	private int startBlock;
	private int endBlock;
	
	private ArrayList<P_Hospital> addressLists;
	
	public P_HospitalPaging() {
		this.cpage = 1;
		this.recordPerPage = 4 ;
		this.blockPerPage = 5 ;
		this.totalPage = 1 ;
		this.totalRecord = 0 ;
	}
}
