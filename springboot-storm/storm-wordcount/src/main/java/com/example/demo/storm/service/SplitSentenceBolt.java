package com.example.demo.storm.service;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.Map;

/**
 * 路径：com.storm.demo
 * 类名：
 * 功能：《用一句话描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/7/24 21:48
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class SplitSentenceBolt extends BaseRichBolt {

    private OutputCollector collector;

    //初始化方法
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.collector = outputCollector;
    }

    //被storm框架while(true) 循环调用 传入参数tuple
    public void execute(Tuple tuple) {
        String line = tuple.getString(0);
        String[] words = line.split(" ");
        for(String word : words){
            this.collector.emit(new Values(word,1));
        }

    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("word","count"));
    }
}
