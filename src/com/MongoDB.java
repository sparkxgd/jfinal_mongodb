package com;
 
import org.bson.Document;
 
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
 
public class MongoDB {
	public static MongoDatabase mongoDatabase;
	private static String tableName ="student";
	private static MongoCollection<Document> collection=mongoDatabase.getCollection(tableName);;
	
	   //插入文档  
    /** 
    * 1. 创建文档 org.bson.Document 参数为key-value的格�? 
    * 2. 创建文档集合List<Document> 
    * 3. 将文档集合插入数据库集合�? mongoCollection.insertMany(List<Document>) 插入单个文档可以�? mongoCollection.insertOne(Document) 
    * */
	public static boolean add(Document document) {
		collection.insertOne(document);
		return true;
	}
	/**
	 * 删除
	 * @param fieldName
	 * @param value
	 * @return
	 */
	public static boolean delOne(String fieldName, Object value) {
		collection.deleteOne(Filters.eq(fieldName, value));
		return true;
	}
	//�?索所有文�?  
    /** 
    * 1. 获取迭代器FindIterable<Document> 
    * 2. 获取游标MongoCursor<Document> 
    * 3. 通过游标遍历�?索出的文档集�? 
    * */  
	public static FindIterable<Document> find() {
		FindIterable<Document> findIterable = collection.find();
		return findIterable;
	}
	public static UpdateResult update(String fieldName, Object value,String upatefieldName, Object updatevalue) {
		//更新文档   将文档中likes=100的文档修改为likes=200   
        UpdateResult r=collection.updateMany(Filters.eq(fieldName, 100), new Document("$set",new Document(upatefieldName,updatevalue)));  
		return r;
	}
}
