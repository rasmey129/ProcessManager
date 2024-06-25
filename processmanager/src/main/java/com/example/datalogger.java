package com.example;
import java.util.ArrayList;
import java.util.List; 

public class datalogger {
    private List<Double> cpuHistory;
    private List<Long> memoryHistory;
    private List<Long> SentNetworkHistory;
    private List<Long> RecNetworkHistory;


    public datalogger(){
        cpuHistory = new ArrayList<>();
        memoryHistory = new ArrayList<>();
        SentNetworkHistory = new ArrayList<>();
        RecNetworkHistory = new ArrayList<>();
    }

    public void logCpuUsage(double usage) {
        cpuHistory.add(usage);
    }

    public void logMemoryUsage(Long usage){
        memoryHistory.add(usage);
    }

    public void logSentNetwork(Long bytesSent){
        SentNetworkHistory.add(bytesSent);
    }

    public void logRecNetwork(Long bytesRec){
        RecNetworkHistory.add(bytesRec);
    }

    public List<Double> getCpuHistory(){
        return cpuHistory;
    }

    public List<Long> getMemoryHistory(){
        return memoryHistory;
    }

}
