package com.example.demo.storm.service;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.Map;

/**
 * 路径：com.storm.demo
 * 类名：
 * 功能：《用一句话描述一下》
 * 备注：
 * 创建人：tanyinping
 * 创建时间：2018/7/24 21:44
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class SentenceSpout extends BaseRichSpout {

    private SpoutOutputCollector collector;

    //初始化方法
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.collector = spoutOutputCollector;
    }

    //storm框架在while(true) 调用nextTuple
    public void nextTuple() {
        collector.emit(new Values("i am love storm"));
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("love"));
    }
}
