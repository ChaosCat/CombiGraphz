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