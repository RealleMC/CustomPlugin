/*
 * Copyright (c) 2021. This program is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program.  If not, see <https://www.gnu.org/licenses/gpl-3.0.html>
 *
 *  Contact information:
 *  Richard Simpson <magnum1997@gmail.com>
 *  19084 Leaf Lane
 *  Redding, CA 96003
 *  USA
 */

package com.reallemc;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

public class Common extends JavaPlugin {

    private static Logger logger = Bukkit.getLogger();
    @SuppressWarnings("deprecation")
    public static Optional<UUID> fetchPlayerByName(String name) {
        UUID uid;
        OfflinePlayer p = Bukkit.getOfflinePlayer(name);
        return Optional.of(p.getUniqueId());

    }
    public static String colorize(String string){
        return ChatColor.translateAlternateColorCodes('&',string);
    }
    public static void tell(Player player,String message){
        player.sendMessage(Component.text(message));
    }
    // ------------------------------------------------------------------------------------------------------------
    // Colorizing messages
    // ------------------------------------------------------------------------------------------------------------

    /**
     * Replaces & colors for every string in the list
     * A new list is created only containing non-null list values
     *
     * @param list
     * @return
     */
    public static List<String> colorize(final List<String> list) {
        final List<String> copy = new ArrayList<>();
        copy.addAll(list);

        for (int i = 0; i < copy.size(); i++) {
            final String message = copy.get(i);

            if (message != null)
                copy.set(i, colorize(message));
        }

        return copy;
    }

    // ------------------------------------------------------------------------------------------------------------
    // Logging and error handling
    // ------------------------------------------------------------------------------------------------------------
    /**
     * Logs a bunch of messages to the console, & colors are supported
     *
     * @param messages
     */
    public static void log(final String... messages) {
        log(messages);
    }
    public static void log (final String message) {
    logger.info(message);
    }

}