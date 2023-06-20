package com.example.demo.entity;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class P_FoodPaging {
	private int cpage;
	private int recordPerPage;
	private int blockPerPage;
	private int totalPage;
	private int totalRecord;
	private int startBlock;
	private int endBlock;
	
	private ArrayList<P_Food> addressLists;
	
	public P_FoodPaging() {
		this.cpage = 1;
		this.recordPerPage = 3 ;
		this.blockPerPage = 5 ;
		this.totalPage = 1 ;
		this.totalRecord = 0 ;
	}
}
