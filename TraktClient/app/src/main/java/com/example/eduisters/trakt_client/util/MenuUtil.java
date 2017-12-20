package com.example.eduisters.trakt_client.util;

import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

/**
 * Created by Erik Duisters on 19-12-2017.
 */

public class MenuUtil {
    private MenuUtil() {}

    public static void updateMenu(Menu menu, MyMenuItem myMenuItem) {
        MenuItem item = menu.findItem(myMenuItem.id);

        if (item != null) {
            item.setEnabled(myMenuItem.enabled);
            item.setVisible(myMenuItem.visible);
        }
    }

    public static void updateMenu(Menu menu, List<MyMenuItem> myMenu) {
        for (MyMenuItem myItem : myMenu) {
            MenuItem item = menu.findItem(myItem.id);

            if (item != null) {
                item.setVisible(myItem.visible);
                item.setEnabled(myItem.enabled);
            }
        }
    }
}
