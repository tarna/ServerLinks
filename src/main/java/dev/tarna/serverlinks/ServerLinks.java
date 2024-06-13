package dev.tarna.serverlinks;

import org.bukkit.plugin.java.JavaPlugin;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

public final class ServerLinks extends JavaPlugin {
    public HashMap<String, URI> links = new HashMap<>();

    @Override
    public void onEnable() {
        long now = System.currentTimeMillis();

        saveDefaultConfig();
        new ServerLinksReload(this);
        new ServerLinksSendListener(this);
        loadLinks();

        getLogger().info("ServerLinks has been enabled in " + (System.currentTimeMillis() - now) + "ms");
    }

    @Override
    public void onDisable() {
        long now = System.currentTimeMillis();

        getLogger().info("ServerLinks has been disabled in " + (System.currentTimeMillis() - now) + "ms");
    }

    void loadLinks() {
        links.clear();
        var keys = getConfig().getKeys(false);
        for (String key : keys) {
            String value = getConfig().getString(key);
            try {
                links.put(key, new URI(value.replace("&", "§")));
            } catch (URISyntaxException e) {
                getLogger().warning("Invalid URI for key " + key + ": " + value);
            }
        }
        getLogger().info("Loaded " + keys.size() + " links");
    }
}
