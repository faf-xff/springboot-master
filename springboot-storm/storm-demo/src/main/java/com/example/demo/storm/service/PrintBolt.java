package com.example.demo.storm.service;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 路径：com.example.demo
 * 类名：
 * 功能：《用一句话描述一下》
 * 备注：
 * 创建人：tanyinping
 * 创建时间：2018/7/23 11:23
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class PrintBolt extends BaseRichBolt {

    private static Logger log = LoggerFactory.getLogger(PrintBolt.class);

    OutputCollector outputCollector;

    public void prepare(Map conf, TopologyContext context, OutputCollector collector) {
        this.outputCollector = collector;
    }

    public void execute(Tuple tuple) {
        log.info(tuple.getString(0) + " Hello World!");

        this.outputCollector.ack(tuple);
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
    }
}
