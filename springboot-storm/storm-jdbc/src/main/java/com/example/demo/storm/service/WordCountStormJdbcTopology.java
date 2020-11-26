package com.example.demo.storm.service;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;

/**
 * 路径：com.storm.demo
 * 类名：
 * 功能：《用一句话描述一下》
 * 备注：
 * 创建人：tanyinping
 * 创建时间：2018/7/25 16:36
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class WordCountStormJdbcTopology {

    public static void main(String[] args) {

        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("spout", new WordCountSpout());
        builder.setBolt("bolt", new CountBolt()).shuffleGrouping("spout");

        Config config = new Config();
        config.setNumWorkers(3);

        //本地模式
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("stormJdbcTopology", config, builder.createTopology());



    }

}
