package com;


import org.bson.Document;

import com.jfinal.core.Controller;
import com.mongodb.client.FindIterable;

public class HelloController extends Controller{
	
	 public void index() {
		 render("index.html");
	 }
	 public void getSudents() {
		 FindIterable<Document> list=MongoDB.find();
		 setAttr("list", list);
		 renderJson();
	 }
	
}
