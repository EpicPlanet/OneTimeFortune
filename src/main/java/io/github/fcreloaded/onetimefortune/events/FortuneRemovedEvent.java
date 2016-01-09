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
package io.github.fcreloaded.onetimefortune.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockBreakEvent;

/**
 * The event called when a fortune enchantment is removed or decreased.
 * @author Final Child
 * @version 1.0
 * @since 1.0
 */
public class FortuneRemovedEvent extends Event implements Cancellable {

    /**
     * The BlockBreakEvent.
     * @since 1.0
     */
    private BlockBreakEvent event;
    /**
     * The handlers.
     * @since 1.0
     */
    private static final HandlerList handlers = new HandlerList();
    /**
     * IsCancelled.
     * @since 1.0
     */
    private boolean isCancelled;

    /**
     * The Constructor.
     * @param event The BlockBreakEvent.
     * @since 1.0
     */
    public FortuneRemovedEvent(BlockBreakEvent event) {
        this.event = event;
        this.isCancelled = false;
    }

    /**
     * Returns the BlockBreakEvent
     * @return The BlockBreakEvent.
     * @since 1.0
     */
    public BlockBreakEvent getEvent() {
        return this.event;
    }

    /* (non-Javadoc)
     * @see org.bukkit.event.Event#getHandlers()
     */
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    /* (non-Javadoc)
     * @see org.bukkit.event.Cancellable#isCancelled()
     */
    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    /* (non-Javadoc)
     * @see org.bukkit.event.Cancellable#setCancelled(boolean)
     */
    @Override
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }
}
