package com;
 
import com.jfinal.plugin.IPlugin;
import com.mongodb.MongoClient;
 
public class MongoPlugin implements IPlugin{
	private String host;
	private int port;
	private String dbname;
	MongoClient mongoClient;
	

	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	@Override
	public boolean start() {

		// 连接到 mongodb 服务
       try {
    	   mongoClient = new MongoClient(host,port);
		   // 连接到数据库
    	   MongoDB.mongoDatabase = mongoClient.getDatabase(dbname);
	} catch (Exception e) {
		e.printStackTrace();
	}
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