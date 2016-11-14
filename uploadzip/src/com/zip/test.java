package com.zip;

public class test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String sourceFile="D:/pypy_win32_gr.zip";
		
		DeCompressUtil.deCompress(sourceFile, "D:/SogouInput");

	}

}
