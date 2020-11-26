package com.example.demo.jFreeChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;

import java.awt.*;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

/**
 * 路径：com.example.demo.jFreeChart
 * 类名：
 * 功能：JFreeChart生成图表
 * 备注：
 * 创建人：typ
 * 创建时间：2018/11/7 11:21
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class ChartUtils {

    /**
     * 方法名：
     * 功能：生成柱状图
     * 描述：
     * 创建人：typ
     * 创建时间：2018/11/7 11:23
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static void getBarChart(DefaultCategoryDataset dataset, String pathName) {
        try {
            JFreeChart chart = ChartFactory.createBarChart3D(
                    "水果", // 图表标题
                    "水果种类", // 目录轴的显示标签
                    "数量", // 述职轴的显示标签
                    dataset, // 数据集
                    PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                    true, // 是否显示图例(对于简单的柱状图必须是false)
                    false, // 是否生成工具
                    false // 是否生成URL链接
            );

            // 获取图表区域对象
            CategoryPlot plot = chart.getCategoryPlot();
            // 水平底部列
            CategoryAxis axis = plot.getDomainAxis();
            // 水平底部标题
            axis.setLabelFont(new Font("黑体", Font.BOLD, 14));
            // 垂直标题
            axis.setTickLabelFont(new Font("宋体", Font.BOLD, 12));
            // 获取柱状
            ValueAxis valueAxis = plot.getRangeAxis();
            valueAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
            chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
            // 设置标题字体
            chart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));

            //将内存中的图片写到本地硬盘
            ChartUtilities.saveChartAsJPEG(new File(pathName), chart, 600, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 方法名：
     * 功能：饼状图
     * 描述：
     * 创建人：typ
     * 创建时间：2018/11/7 11:51
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static void getPieChart(DefaultPieDataset dataset, String pathName) {
        try {
            JFreeChart chart = ChartFactory.createPieChart3D("水果产量", dataset, true, false, false);
            //设置百分比
            PiePlot pieplot = (PiePlot) chart.getPlot();
            //获得一个DecimalFormat对象，主要是设置小数问题
            DecimalFormat df = new DecimalFormat("0.00%");
            //获得一个NumberFormat对象
            NumberFormat nf = NumberFormat.getNumberInstance();
            //获得StandardPieSectionLabelGenerator对象
            StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);
            pieplot.setLabelGenerator(sp1);//设置饼图显示百分比

            //没有数据的时候显示的内容
            pieplot.setNoDataMessage("无数据显示");
            pieplot.setCircular(false);
            pieplot.setLabelGap(0.02D);
            //设置不显示空值
            pieplot.setIgnoreNullValues(true);
            //设置不显示负值
            pieplot.setIgnoreZeroValues(true);
            //设置标题字体
            chart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));
            //获取图表区域对象
            PiePlot piePlot = (PiePlot) chart.getPlot();
            //解决乱码
            piePlot.setLabelFont(new Font("宋体", Font.BOLD, 10));
            chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 10));
            //将内存中的图片写到本地硬盘
            ChartUtilities.saveChartAsJPEG(new File(pathName), chart, 600, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法名：
     * 功能：折线图
     * 描述：
     * 创建人：typ
     * 创建时间：2018/11/7 11:55
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static void getLineChart(XYDataset dataset, String pathName) {
        try {
            JFreeChart chart = ChartFactory.createTimeSeriesChart("Legal & General单位信托基金价格", "日期", "价格", dataset, true, true, true);
            XYPlot xyplot = (XYPlot) chart.getPlot();
            DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
            dateaxis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
            //水平底部标题
            dateaxis.setLabelFont(new Font("黑体", Font.BOLD, 14));
            //垂直标题
            dateaxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12));
            //获取
            ValueAxis rangeAxis = xyplot.getRangeAxis();
            rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
            chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
            //设置标题字体
            chart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));
            //将内存中的图片写到本地硬盘
            ChartUtilities.saveChartAsJPEG(new File(pathName), chart, 600, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
