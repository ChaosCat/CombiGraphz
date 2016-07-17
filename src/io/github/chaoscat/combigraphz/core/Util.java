package io.github.chaoscat.combigraphz.core;

import java.awt.event.KeyEvent;

/**
 * Created by Elian on 7/16/2016.
 */
public final class Util {

    private Util() {
        throw new AssertionError();
    }

    public static boolean isNotNumFriendlyKey(int key) {
        return (key != KeyEvent.VK_BACK_SPACE) && (key < '0' || key > '9');
    }

}
