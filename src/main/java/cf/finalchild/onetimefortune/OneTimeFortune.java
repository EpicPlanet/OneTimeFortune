/*
 * OneTimeFortune - a brief idea of what it does
 * Copyright (C) 2016 Final Child
 *
 * This file is part of OneTimeFortune.
 *
 * OneTimeFortune is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * OneTimeFortune is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OneTimeFortune.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * This file is part of OneTimeFortune.

 * OneTimeFortune is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * OneTimeFortune is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with OneTimeFortune.  If not, see <http://www.gnu.org/licenses/>.
 */
package cf.finalchild.onetimefortune;

import org.bukkit.plugin.java.JavaPlugin;

import cf.finalchild.onetimefortune.listeners.FortuneListener;

/**
 * The main class of the OneTimeFortune Bukkit plugin.
 * @author Final Child
 * @version 1.0
 * @since 1.0
 */
public class OneTimeFortune extends JavaPlugin {

    /**
     * Alert when loaded.
     * @since 1.0
     */
    @Override
    public void onLoad() {
        getLogger().info("OneTimeFortune is disabled.");
    }

    /**
     * Alert when enabled.
     * @since 1.0
     */
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new FortuneListener(this), this);
        getLogger().info("OneTimeFortune is enabled.");
    }

    /**
     * Alert when disabled.
     * @since 1.0
     */
    @Override
    public void onDisable() {
        getLogger().info("OneTimeFortune is disabled.");
    }
}
