package dev.tarna.serverlinks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    private final ServerLinks plugin;
    PlayerJoinListener(ServerLinks plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        var serverLinks = Bukkit.getServerLinks();
        for (String key : this.plugin.links.keySet()) {
            serverLinks.addLink(key, this.plugin.links.get(key));
        }
        player.sendLinks(serverLinks);
    }
}
