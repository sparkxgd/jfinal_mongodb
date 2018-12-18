package com;
 
import org.bson.Document;
 
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
 
public class StudentModel {
	private MongoCollection<Document> collection;
	private String tableName ="student";
	
	public StudentModel(MongoPlugin mongo) {
		this.collection = mongo.getDB().getCollection(tableName);
	}
	   //插入文档  
    /** 
    * 1. 创建文档 org.bson.Document 参数为key-value的格式 
    * 2. 创建文档集合List<Document> 
    * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document) 
    * */
	public boolean add(Document document) {
		collection.insertOne(document);
		return true;
	}
	/**
	 * 删除
	 * @param fieldName
	 * @param value
	 * @return
	 */
	public boolean delOne(String fieldName, Object value) {
		collection.deleteOne(Filters.eq(fieldName, value));
		return true;
	}
	//检索所有文档  
    /** 
    * 1. 获取迭代器FindIterable<Document> 
    * 2. 获取游标MongoCursor<Document> 
    * 3. 通过游标遍历检索出的文档集合 
    * */  
	public FindIterable<Document> find() {
		FindIterable<Document> findIterable = collection.find();
		return findIterable;
	}
	public UpdateResult update(String fieldName, Object value,String upatefieldName, Object updatevalue) {
		//更新文档   将文档中likes=100的文档修改为likes=200   
        UpdateResult r=collection.updateMany(Filters.eq(fieldName, 100), new Document("$set",new Document(upatefieldName,updatevalue)));  
		return r;
	}
}
