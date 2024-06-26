package com.example;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;   
import java.awt.*;
import java.util.List;

public class charts extends JFrame{
    private final JFrame frame;
    private final DefaultCategoryDataset cpuDataset;
    private final DefaultCategoryDataset memoryDataset;
    private final DefaultCategoryDataset networkSentDataset;
    private final DefaultCategoryDataset networkReceivedDataset;
        
    public charts() {
        frame = new JFrame("Resource Monitor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));

        cpuDataset = new DefaultCategoryDataset();
        memoryDataset = new DefaultCategoryDataset();
        networkSentDataset = new DefaultCategoryDataset();
        networkReceivedDataset = new DefaultCategoryDataset();

            JFreeChart cpuChart = ChartFactory.createLineChart(
                "CPU Usage", "Time", "Usage",
                cpuDataset, PlotOrientation.VERTICAL,   
                true,true,false
            );
            JFreeChart memoryChart = ChartFactory.createLineChart(
                "Memory Usage", "Time", "Usage",
                memoryDataset, PlotOrientation.VERTICAL,   
                true,true,false
            );
            JFreeChart networkSentChart = ChartFactory.createLineChart(
                "network sent", "Time", "Bytes",
                networkSentDataset, PlotOrientation.VERTICAL,   
                true,true,false
            );
            JFreeChart networkReceivedChart = ChartFactory.createLineChart(
                "network recieved", "Time", "Bytes",
                networkReceivedDataset, PlotOrientation.VERTICAL,   
                true,true,false
            );

        frame.add(new ChartPanel(cpuChart));
        frame.add(new ChartPanel(memoryChart));
        frame.add(new ChartPanel(networkSentChart));
        frame.add(new ChartPanel(networkReceivedChart));
        frame.pack();
        frame.setVisible(true);
         }

    public void updateCpuChart(List<Double> cpuHistory) {
        cpuDataset.clear();
        for (int i = 0; i < cpuHistory.size(); i++) {
            cpuDataset.addValue(cpuHistory.get(i), "CPU Usage", Integer.toString(i));
        }
    }
    public void updateMemoryChart(List<Long> memoryHistory) {
        memoryDataset.clear();
        for (int i = 0; i < memoryHistory.size(); i++) {
            memoryDataset.addValue(memoryHistory.get(i), "memory Usage", Integer.toString(i));
        }
    }
    public void updateSentNetworkChart(List<Long> SentNetworkHistory) {
        networkSentDataset.clear();
        for (int i = 0; i < SentNetworkHistory.size(); i++) {
            networkSentDataset.addValue(SentNetworkHistory.get(i), "Sent Network", Integer.toString(i));
        }
    }
    public void updateRecNetworkChart(List<Long> RecNetworkHistory) {
        networkReceivedDataset.clear();
        for (int i = 0; i < RecNetworkHistory.size(); i++) {
            networkReceivedDataset.addValue(RecNetworkHistory.get(i), "Recieved Network", Integer.toString(i));
        }
    }
 }

