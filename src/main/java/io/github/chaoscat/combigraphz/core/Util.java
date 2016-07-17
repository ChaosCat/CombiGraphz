//                 Copyright 2016 Elian Kamal
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
package io.github.chaoscat.combigraphz.core;

import java.awt.event.KeyEvent;

/**
 * A utility class with static methods
 *
 * @author Elian Kamal
 * @version 1.0
 */
public final class Util {

    private Util() {
        throw new AssertionError();
    }

    public static boolean isNotNumFriendlyKey(int key) {
        return (key != KeyEvent.VK_BACK_SPACE) && (key < '0' || key > '9');
    }

}
