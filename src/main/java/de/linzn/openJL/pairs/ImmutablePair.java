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

package de.linzn.openJL.pairs;

public class ImmutablePair<L, R> {
    public final L left;
    public final R right;

    /**
     * Create a new pair instance.
     *
     * @param left  the left value, may be null
     * @param right the right value, may be null
     */
    public ImmutablePair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Gets the left element from this pair.
     *
     * @return the left element, may be null
     */
    public L getLeft() {
        return left;
    }

    /**
     * Gets the right element from this pair.
     *
     * @return the right element, may be null
     */
    public R getRight() {
        return right;
    }

    /**
     * Throws UnsupportedOperationException.
     * This pair is immutable, so this operation is not supported.
     *
     * @param value the value to set
     * @return never
     */
    public R setValue(R value) {
        throw new UnsupportedOperationException("This pair is immutable, so this operation is not supported");
    }
}
