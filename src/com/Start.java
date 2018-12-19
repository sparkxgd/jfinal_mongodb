package com;

import com.jfinal.core.JFinal;

public class Start {

	public static void main(String[] args) {
			JFinal.start("WebContent", 8082, "/", 5);
		}
}
