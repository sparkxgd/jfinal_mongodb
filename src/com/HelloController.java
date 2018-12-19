package com;


import java.util.List;

import org.bson.Document;

import com.jfinal.core.Controller;

public class HelloController extends Controller{
	
	 public void index() {
		 render("index.html");
	 }
	 public void getSudents() {
		 List<Document> list=MongoDB.find();
		 setAttr("list", list);
		 renderJson();
	 }
	public void openAdd() {
		render("add.html");
	}
	public void save() {
		String no=getPara("no");
		String name=getPara("name");
		String age=getPara("age");
		String cls=getPara("cls");
		String sex=getPara("sex");
		MongoDB.add(no, name, sex, cls, age);
		redirect("/mongo");
//		setAttr("result", 0);
//		renderJson();
	}
	public void del() {
		String no=getPara("no");
		MongoDB.delOne("no",no);
//		setAttr("result", 0);
//		renderJson();
		redirect("/mongo");
	}
}
