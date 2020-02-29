/*
 * Copyright (C) 2020. Niklas Linz - All Rights Reserved
 * You may use, distribute and modify this code under the
 * terms of the LGPLv3 license, which unfortunately won't be
 * written for another century.
 *
 * You should have received a copy of the LGPLv3 license with
 * this file. If not, please write to: niklas.linz@enigmar.de
 *
 */

package de.linzn.openJL.pairs;

public class EditablePair<L, R> {
    private L left;
    private R right;

    /**
     * Create a new editable pair instance.
     *
     * @param left  the left value, may be null
     * @param right the right value, may be null
     */
    public EditablePair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Gets the left element from this editable pair.
     *
     * @return the left element, may be null
     */
    public L getLeft() {
        return left;
    }

    /**
     * Gets the right element from this editable pair.
     *
     * @return the right element, may be null
     */
    public R getRight() {
        return right;
    }

    /**
     * Set the right element of this editable pair
     *
     * @param value the value to set
     */
    public void setValue(R value) {
        this.right = value;
    }
}
