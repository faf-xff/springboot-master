package com.example.demo.storm.service;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;

import java.util.HashMap;
import java.util.Map;

/**
 * 路径：com.storm.demo
 * 类名：
 * 功能：《用一句话描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/7/24 21:52
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class WordCountBolt extends BaseRichBolt {

    private OutputCollector collector;

    private HashMap<String,Integer> map = new HashMap<String, Integer>();

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.collector = outputCollector;
    }

    public void execute(Tuple tuple) {
        String word = tuple.getString(0);
        Integer num = tuple.getInteger(1);
        if(map.containsKey(word)){
            Integer count = map.get(word);
            map.put(word,count+num);
        }else{
            map.put(word,1);
        }
        System.out.println("=======count======"+map);
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
//        declarer.declare(new Fields("word","count"));
    }
}
