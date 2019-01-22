package com.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day2_2 {
	@Test
	public void demotestdemowebshoplogin(){
		System.out.println();
	}

	@DataProvider 
	public Object getdatafromexcel(){
		return ReadExcel.testexcel();
	}
}
