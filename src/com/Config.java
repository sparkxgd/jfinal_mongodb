package com;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.template.Engine;

public class Config extends JFinalConfig{

	@Override
	public void configConstant(Constants me) {
		 me.setDevMode(true);	
	}

	@Override
	public void configRoute(Routes me) {
		me.setBaseViewPath("/WEB-INF");
		me.add("/mongo", HelloController.class,"page");
	}

	@Override
	public void configEngine(Engine me) {
		
	}

	@Override
	public void configPlugin(Plugins me) {
		MongoPlugin mp=new MongoPlugin();
		mp.setHost("127.0.0.1");
		mp.setPort(27017);
		mp.setDbname("kaili");
		me.add(mp);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		
	}

}
