package com.example.demo.service.impl;

import com.example.demo.domain.EchartsPOJO;
import com.example.demo.service.ITimeFlow;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TimeFlowImpl implements ITimeFlow {
    @Override
    public Map GetTimeFlow() {
        //创建MongoDB数据库对象,连接MongoDB
        MongoClient mongoClient = new MongoClient("localhost",27017);
        //指定使用的数据库和集合
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = mongoDatabase.getCollection("time_flow");
        //设定条件
        //获取数据
        Document query = new Document("id",1);
        FindIterable<Document> findIterable = collection.find(query);
        /**
         *遍历findIterable
         *获取时间和流量
         **/
        int count = 0;//计数器,保证获取的key是date而不是其他数据
        List<EchartsPOJO> list = new ArrayList<>();//存储EchartsPOJO
        for (Document fi : findIterable){
            Iterator<String> iterator = fi.keySet().iterator();
            /**
             *迭代器遍历
             *获取key和value(日期和流量)
             **/
            while (iterator.hasNext()){
                //获得key
                String key = iterator.next();
                if(count > 1){
                    Integer value = fi.getInteger(key);
                    list.add(new EchartsPOJO(key,value));
                }
                count++;
            }
        }
        Map map = new HashMap();
        map.put("list",list);
        return map;
    }
}
