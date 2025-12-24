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

package de.linzn.openJL.converter;

public class BooleanAdapter {

    /**
     * Converting a boolean value to an integer value like 0 and 1
     *
     * @param value Boolean value for convert to an integer value
     * @return The boolean value as an integer. (0 or 1)
     */
    public static int adapt(boolean value) {
        int intValue = 0;
        if (value)
            intValue = 1;
        return intValue;
    }

    /**
     * Converting an integer value like 0 and 1 to an boolean value
     * throw IllegalArgumentException
     *
     * @param intValue Integer value for convert to boolean
     * @return The integer as a boolean value . (false or true)
     */
    public static boolean adapt(int intValue) {
        if (intValue != 0 && intValue != 1) throw new IllegalArgumentException();
        boolean value = false;
        if (intValue == 1) {
            value = true;
        }
        return value;
    }
}
