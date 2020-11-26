package com.example.demo.storm.service;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.Map;
import java.util.Random;

/**
 * 路径：com.storm.demo
 * 类名：
 * 功能：《用一句话描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/7/25 15:51
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class WordCountSpout extends BaseRichSpout {

    private SpoutOutputCollector collector;

    private static final String[] words = new String[]{"aaa","bbb","cad","adv","ed","eaf"};

    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.collector = spoutOutputCollector;
    }
    
    /**
     * 方法名：
     * 功能：把每一行数据发射出去
     * 描述：
     * 创建人：tanyinping
     * 创建时间：2018/7/25 15:58
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public void nextTuple() {
        Random random = new Random();
        String word = words[random.nextInt(words.length)];
        //发射出去
        this.collector.emit(new Values(word));
        System.out.println("emit==="+word);
//        Utils.sleep(1000);
    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("word"));
    }
}
