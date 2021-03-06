/*------------------------------------------------------------------------------
 Copyright (c) CovertJaguar, 2011-2016
 http://railcraft.info

 This code is the property of CovertJaguar
 and may only be used with explicit written
 permission unless otherwise specified on the
 license page at http://railcraft.info/wiki/info:license.
 -----------------------------------------------------------------------------*/
package mods.railcraft.common.blocks.tracks.outfitted.kits;

import mods.railcraft.api.tracks.ITrackKitInstance;
import mods.railcraft.api.tracks.TrackKit;
import mods.railcraft.api.tracks.TrackKitInstance;
import mods.railcraft.common.blocks.tracks.TrackTools;
import mods.railcraft.common.blocks.tracks.outfitted.TrackKits;
import mods.railcraft.common.plugins.forge.WorldPlugin;
import net.minecraft.block.BlockRailBase;

/**
 * @author CovertJaguar <http://www.railcraft.info>
 */
public abstract class TrackKitRailcraft extends TrackKitInstance {

    public abstract TrackKits getTrackKitContainer();

    @Override
    public TrackKit getTrackKit() {
        return getTrackKitContainer().getTrackKit();
    }

    public int getPowerPropagation() {
        return 0;
    }

    public boolean canPropagatePowerTo(ITrackKitInstance track) {
        return true;
    }

    public BlockRailBase.EnumRailDirection getTrackShape() {
        return TrackTools.getTrackDirectionRaw(WorldPlugin.getBlockState(theWorldAsserted(), getPos()));
    }
}
