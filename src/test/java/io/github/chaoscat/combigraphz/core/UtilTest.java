//                 Copyright 2016 Elian Kamal
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//          http://www.apache.org/licenses/LICENSE-2.0
package io.github.chaoscat.combigraphz.core;

import org.junit.Test;

import java.awt.event.KeyEvent;

import static org.junit.Assert.assertEquals;

/**
 * Created by Elian on 7/17/2016.
 */
public class UtilTest {

    @Test
    public void isNotNumFriendlyKey() {
        for (int i = 0; i <= 377; i++) {
            if ((i >= '0' && i <= '9') || i == KeyEvent.VK_BACK_SPACE)
                assertEquals(Util.isNotNumFriendlyKey(i), false);
            else
                assertEquals(Util.isNotNumFriendlyKey(i), true);
        }
    }
}