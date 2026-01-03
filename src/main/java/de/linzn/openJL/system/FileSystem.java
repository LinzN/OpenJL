/*
 * Copyright (c) 2026 MirraNET, Niklas Linz. All rights reserved.
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
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystem {

    public static Path getFilePath(Class<?> clazz) throws URISyntaxException {
        return Paths.get(clazz.getProtectionDomain().getCodeSource().getLocation().toURI());
    }

    public static Path getFileDirectoryPath(Class<?> clazz) throws URISyntaxException {
        return Paths.get(clazz.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();
    }

    public static boolean deleteFolder(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (!deleteFolder(f)) {
                        return false;
                    }
                }
            }
        }
        return file.delete();
    }
}
