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

package de.linzn.openJL.network;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class IPAddressMatcher {
    private final int nMaskBits;
    private final InetAddress requiredAddress;


    public IPAddressMatcher(String ipAddress) {

        if (ipAddress.indexOf('/') > 0) {
            String[] addressAndMask = ipAddress.split("/");
            ipAddress = addressAndMask[0];
            nMaskBits = Integer.parseInt(addressAndMask[1]);
        } else {
            nMaskBits = -1;
        }
        requiredAddress = parseAddress(ipAddress);
        assert (requiredAddress.getAddress().length * 8 >= nMaskBits) :
                String.format("IP address %s is too short for bitmask of length %d",
                        ipAddress, nMaskBits);
    }

    public boolean matches(String address) {
        InetAddress remoteAddress = parseAddress(address);

        if (!requiredAddress.getClass().equals(remoteAddress.getClass())) {
            return false;
        }

        if (nMaskBits < 0) {
            return remoteAddress.equals(requiredAddress);
        }

        byte[] remAddr = remoteAddress.getAddress();
        byte[] reqAddr = requiredAddress.getAddress();

        int nMaskFullBytes = nMaskBits / 8;
        byte finalByte = (byte) (0xFF00 >> (nMaskBits & 0x07));


        for (int i = 0; i < nMaskFullBytes; i++) {
            if (remAddr[i] != reqAddr[i]) {
                return false;
            }
        }

        if (finalByte != 0) {
            return (remAddr[nMaskFullBytes] & finalByte) == (reqAddr[nMaskFullBytes] & finalByte);
        }

        return true;
    }

    private InetAddress parseAddress(String address) {
        try {
            return InetAddress.getByName(address);
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException("Failed to parse address" + address, e);
        }
    }
}