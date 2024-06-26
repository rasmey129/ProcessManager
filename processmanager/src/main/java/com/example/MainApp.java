package com.example;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import oshi.hardware.common.*;;

public class MainApp {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        datalogger logger = new datalogger();
        charts display = new charts();
        
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask(){
        @Override
        public void run() {
            double cpuUsage = monitor.getCpuUsage();
            Long AvailableMemory = monitor.getAvailableMemory();
            Long Totalmemory = monitor.getTotalMemory();
            long UsedMemory = Totalmemory - AvailableMemory;
            long networkSent = monitor.getNetworkBytesSent();
            long networkReceived = monitor.getNetworkBytesReceived();


            logger.logCpuUsage(cpuUsage);
            logger.logMemoryUsage(UsedMemory);
            logger.logSentNetwork(networkSent);
            logger.logRecNetwork(networkReceived);

            display.updateCpuChart(logger.getCpuHistory());
            display.updateMemoryChart(logger.getMemoryHistory());
            display.updateSentNetworkChart(logger.getNetworkByteSent());
            display.updateRecNetworkChart(logger.getNetworkBytesReceived());

        }
    } , 0, 100);
    SwingUtilities.invokeLater(() -> {
        display.setVisible(true);
    });
    
    }

 }

