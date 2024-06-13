package dev.tarna.serverlinks;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLinksSendEvent;

public class ServerLinksSendListener implements Listener {
    private final ServerLinks plugin;
    ServerLinksSendListener(ServerLinks plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onServerLinksSend(PlayerLinksSendEvent event) {
        for (String key : this.plugin.links.keySet()) {
            event.getLinks().addLink(key, this.plugin.links.get(key));
        }
    }
}
