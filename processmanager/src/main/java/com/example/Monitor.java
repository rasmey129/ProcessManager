package com.example;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public class Monitor {
    private final SystemInfo systemInfo;
    private final HardwareAbstractionLayer hardware;
    private final OperatingSystem os;

    public Monitor() {
        systemInfo = new SystemInfo();
        hardware = systemInfo.getHardware();
        os = systemInfo.getOperatingSystem();
    }

    public double getCpuUsage() {
        CentralProcessor processor = hardware.getProcessor();
        double[] load = processor.getSystemLoadAverage(1);
        return load[0];
    }

    public long getTotalMemory() {
        GlobalMemory memory = hardware.getMemory();
        return memory.getTotal();
    }

    public long getAvailableMemory() {
        GlobalMemory memory = hardware.getMemory();
        return memory.getAvailable();
    }

    public long getNetworkBytesSent() {
        return hardware.getNetworkIFs().stream().mapToLong(net -> net.getBytesSent()).sum();
    }

    public long getNetworkBytesReceived() {
        return hardware.getNetworkIFs().stream().mapToLong(net -> net.getBytesRecv()).sum();
    }
}
