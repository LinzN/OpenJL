package de.linzn.openJL.system;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;

public class HardwareResources {

    public static double getSystemLoad() {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        return operatingSystemMXBean.getSystemLoadAverage();
    }

    public static int getCoreAmount() {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        return operatingSystemMXBean.getAvailableProcessors();
    }

    public static double getUsedMemory() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        return (memoryMXBean.getHeapMemoryUsage().getUsed() / (1000 * 1000));
    }

    public static double getMaxMemory() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        return (memoryMXBean.getHeapMemoryUsage().getMax() / (1000 * 1000));
    }

    public static long getUsableSpace() {
        return new File("/").getUsableSpace();
    }

    public static long getTotalSpace() {
        return new File("/").getTotalSpace();
    }
}
