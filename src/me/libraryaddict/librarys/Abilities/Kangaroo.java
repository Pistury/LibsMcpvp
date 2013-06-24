package me.libraryaddict.librarys.Abilities;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import me.libraryaddict.Hungergames.Interfaces.Disableable;
import me.libraryaddict.Hungergames.Types.AbilityListener;

public class Kangaroo extends AbilityListener implements Disableable {
    public float jumpHeight = 2F;
    public String kangarooBootsName = "Kangaroo Boots";

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        if (event.getAction() != Action.PHYSICAL && hasAbility(p) && isSpecialItem(event.getItem(), kangarooBootsName)) {
            Block b = p.getLocation().getBlock();
            if (b.getType() != Material.AIR || b.getRelative(BlockFace.DOWN).getType() != Material.AIR) {
                p.setFallDistance(-(jumpHeight + 1));
                Vector vector = p.getEyeLocation().getDirection();
                vector.multiply(0.6F);
                vector.setY(jumpHeight / 4);
                p.setVelocity(vector);
            }
        }
    }
}
