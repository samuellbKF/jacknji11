/*
 * Copyright 2010-2011 Joel Hockey (joel.hockey@gmail.com). All rights reserved.
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.pkcs11.jacknji11.jna;

import org.pkcs11.jacknji11.CK_MECHANISM_INFO;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

/**
 * JNA wrapper for PKCS#11 CK_MECHANSIM_INFO struct.
 * @author Joel Hockey (joel.hockey@gmail.com)
 */
public class JNA_CK_MECHANISM_INFO extends Structure {
    public NativeLong ulMinKeySize;
    public NativeLong ulMaxKeySize;
    public NativeLong flags;

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("ulMinKeySize", "ulMaxKeySize", "flags");
    }

    public JNA_CK_MECHANISM_INFO readFrom(CK_MECHANISM_INFO info) {
        ulMinKeySize = new NativeLong(info.ulMinKeySize);
        ulMaxKeySize = new NativeLong(info.ulMaxKeySize);
        flags = new NativeLong(info.flags);
        return this;
    }

    public CK_MECHANISM_INFO writeTo(CK_MECHANISM_INFO info) {
        info.ulMinKeySize = ulMinKeySize.intValue();
        info.ulMaxKeySize = ulMaxKeySize.intValue();
        info.flags = flags.intValue();
        return info;
    }
}
