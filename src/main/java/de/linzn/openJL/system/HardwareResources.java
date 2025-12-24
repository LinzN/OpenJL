/*
 * Copyright (c) 2025 MirraNET, Niklas Linz. All rights reserved.
 *
 * This file is part of the MirraNET project and is licensed under the
 * GNU Lesser General Public License v3.0 (LGPLv3).
 *
 * You may use, distribute and modify this code under the terms
 * of the LGPLv3 license. You should have received a copy of the
 * license along with this file. If not, see <https://www.gnu.org/licenses/lgpl-3.0.html>
 * or contact: niklas.linz@mirranet.de
 */

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
