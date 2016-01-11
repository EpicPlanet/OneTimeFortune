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
package io.github.fcreloaded.onetimefortune.listeners;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import io.github.fcreloaded.onetimefortune.OneTimeFortune;
import io.github.fcreloaded.onetimefortune.events.FortuneRemovedEvent;
import io.github.fcreloaded.onetimefortune.utils.FortuneEnchantmentUtils;

/**
 * @author Final Child
 * @version 1.1
 * @since 1.0
 */
public class FortuneListener implements Listener {
    
    /**
     * The OneTimeFortuneplugin instance.
     * @since 1.0
     */
    private OneTimeFortune plugin;

    /**
     * Listens to the BlockBreakEvent.
     * @param event The BlockBreakEvent which is listened to.
     * @since 1.0
     */
    @EventHandler
    public void onFortune(BlockBreakEvent event) {
        if (event.isCancelled()) {
            return;
        }
        if (event.getPlayer().hasPermission("onetimefortune.keep")) {
            return;
        }

        if (FortuneEnchantmentUtils.doesFortuneApply(event)) {
            FortuneRemovedEvent removedEvent = new FortuneRemovedEvent(event);
            Bukkit.getServer().getPluginManager().callEvent(removedEvent);
            if (removedEvent.isCancelled()) {
                return;
            }
            if (event.getPlayer().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 1) {
                plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        event.getPlayer().getItemInHand().removeEnchantment(Enchantment.LOOT_BONUS_BLOCKS);
                    }
                });
            } else {
                plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        event.getPlayer().getItemInHand().addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, event.getPlayer().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) - 1);
                    }
                });
            }
        }
    }
    
    /**
     * The constructor.
     * @param plugin The OneTimeFortune plugin instance.
     * @since 1.0
     */
    public FortuneListener(OneTimeFortune plugin) {
        this.plugin = plugin;
    }
}
