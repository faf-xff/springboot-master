package com.example.demo.storm.service;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.utils.Utils;

/**
 * 路径：com.example.demo
 * 类名：
 * 功能：《用一句话描述一下》
 * 备注：
 * 创建人：tanyinping
 * 创建时间：2018/7/23 11:06
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class ExclamationTopology {

    public static void main(String[] args) throws Exception{
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("word", new WordSpout(),1);
        builder.setBolt("exclaim", new ExclamationBolt(),1).shuffleGrouping("word");
        builder.setBolt("print",new PrintBolt(),1).shuffleGrouping("exclaim");

        Config conf = new Config();
        conf.setDebug(true);

        if(args != null && args.length > 0){
            // 集群模式
            conf.setNumWorkers(3);//设置worker数量
            StormSubmitter.submitTopologyWithProgressBar(args[0], conf, builder.createTopology());
        }else{
            // 本地模式
            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology("test3", conf, builder.createTopology());
            Utils.sleep(20000);
            cluster.killTopology("test3");
            cluster.shutdown();
        }
    }
}
