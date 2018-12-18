package com;
 
import com.jfinal.plugin.IPlugin;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
 
public class MongoPlugin implements IPlugin{
	
	private MongoClient mongoClient;
	private MongoDatabase mongoDatabase;
	
	/**
	 * 启动
	 * @param host
	 * @param port
	 */
	public MongoPlugin(String host,int port,String dbname) {
		// 连接到 mongodb 服务
       try {
    	   mongoClient = new MongoClient(host,port);
		   // 连接到数据库
           mongoDatabase = mongoClient.getDatabase(dbname);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	public MongoDatabase getDB() {
		return mongoDatabase;
	}
	@Override
	public boolean start() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean stop() {
		if(mongoClient!=null) {
			mongoClient.close();
		}
		return true;
	}
 
}