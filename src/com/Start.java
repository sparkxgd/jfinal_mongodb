package com;

import com.jfinal.core.JFinal;

public class Start {

	public static void main(String[] args) {
			// eclipse 下的启动方式
			JFinal.start("WebRoot", 8082, "/", 5);
			
			// IDEA 下的启动方式
			// JFinal.start("src/main/webapp", 80, "/");
		}
}
