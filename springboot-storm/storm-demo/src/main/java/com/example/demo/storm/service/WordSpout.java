package com.example.demo.storm.service;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Random;

/**
 * 路径：com.example.demo
 * 类名：
 * 功能：《用一句话描述一下》
 * 备注：
 * 创建人：tanyinping
 * 创建时间：2018/7/23 11:14
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class WordSpout extends BaseRichSpout {

    public static Logger log = LoggerFactory.getLogger(WordSpout.class);

    SpoutOutputCollector spoutOutputCollector;

    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector){
        this.spoutOutputCollector = collector;
    }

    public void nextTuple(){
        Utils.sleep(100);
        final String[] words = new String[]{"nathan", "mike", "jackson", "golda", "bertels"};
        final Random random = new Random();
        final String word = words[random.nextInt(words.length)];
        this.spoutOutputCollector.emit(new Values(word));
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer){
        declarer.declare(new Fields("word"));
    }
}
