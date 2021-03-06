package buildcraft.api.items;

import buildcraft.api.core.IBox;
import buildcraft.api.core.IZone;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

import java.util.List;

/**
 * Created by asie on 2/28/15.
 */
public interface IMapLocation extends INamedItem {
    public enum MapLocationType {
        CLEAN,
        SPOT,
        AREA,
        PATH,
        ZONE,
        /**
         * Like PATH but repeats around in a loop.
         */
        PATH_REPEATING;

        public final int meta = ordinal();

        public static MapLocationType getFromStack(ItemStack stack) {
            int dam = stack.getItemDamage();
            if (dam < 0 || dam >= values().length) {
                return MapLocationType.CLEAN;
            }
            return values()[dam];
        }

        public void setToStack(ItemStack stack) {
            stack.setItemDamage(meta);
        }
    }

    /**
     * This function can be used for SPOT types.
     *
     * @return The point representing the map location.
     */
    BlockPos getPoint(ItemStack stack);

    /**
     * This function can be used for SPOT and AREA types.
     *
     * @return The box representing the map location.
     */
    IBox getBox(ItemStack stack);

    /**
     * This function can be used for SPOT, AREA and ZONE types. The PATH type needs to be handled separately.
     *
     * @return An IZone representing the map location - also an instance of IBox for SPOT and AREA types.
     */
    IZone getZone(ItemStack stack);

    /**
     * This function can be used for SPOT and PATH types.
     *
     * @return A list of BlockPoses representing the path the Map Location stores.
     */
    List<BlockPos> getPath(ItemStack stack);

    /**
     * This function can be used for SPOT types only.
     *
     * @return The side of the spot.
     */
    EnumFacing getPointSide(ItemStack stack);
}
