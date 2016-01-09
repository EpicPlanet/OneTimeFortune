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
package io.github.fcreloaded.onetimefortune.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Utilities about fortune enchantment.
 * Methods will return true only about the pickaxes' fortune enchantment with ores
 * @author Final Child
 * @version 1.0
 * @since 1.0
 */
public class FortuneEnchantmentUtils {

    /**
     * Returns whether pickaxe fortune enchantments applies at the event
     * @author Final Child
     * @param event The event to get the information
     * @return Whether fortune enchantment applies at the event
     * @since 1.0
     */
    public static boolean doesFortuneApply(BlockBreakEvent event) {
        if (event.getPlayer().getItemInHand() != null) {
            ItemStack itemInHand = event.getPlayer().getItemInHand();
            if (itemInHand.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
                switch (itemInHand.getType()) {
                case WOOD_PICKAXE: case STONE_PICKAXE: case IRON_PICKAXE: case GOLD_PICKAXE: case DIAMOND_PICKAXE:
                    if (doesPickaxeFortuneApply(event.getBlock().getType())) {
                        return true;
                    }
                    return false;       
                default:
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Returns whether pickaxe fortune enchantment applies at the material.
     * @author Final Child
     * @param material the material to get the information.
     * @return Whether pickaxe fortune enchantment applies at the material.
     * @since 1.0
     */
    public static boolean doesPickaxeFortuneApply(Material material) {
        return material.name().endsWith("_ORE");
    }
}