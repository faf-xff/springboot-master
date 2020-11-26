package com.example.demo.storm.service;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;

/**
 * 路径：com.storm.demo
 * 类名：
 * 功能：《用一句话描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/7/24 22:02
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class WordCountTopology {

    public static void main(String[] args) throws Exception {

        //定义一个TopologyBuilder
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("spout",new SentenceSpout(),1);
        builder.setBolt("myBolt1",new SplitSentenceBolt(),10).shuffleGrouping("spout");
        builder.setBolt("myBolt2",new WordCountBolt(),2).fieldsGrouping("myBolt1",new Fields("word"));

        //创建一个Config，用来指定当前topology需要的worker的数量
        Config config = new Config();
        config.setNumWorkers(2);

        //提交任务的两种模式：本地模式和远程模式

        //1.远程模式
//        StormSubmitter.submitTopology("mywordcount",config,builder.createTopology());
        //2.本地模式
        LocalCluster localCluster = new LocalCluster();
        localCluster.submitTopology("mywordcount",config,builder.createTopology());
    }
}
