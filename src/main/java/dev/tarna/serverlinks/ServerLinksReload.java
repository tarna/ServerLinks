package dev.tarna.serverlinks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.List;

public class ServerLinksReload implements TabExecutor {
    private final ServerLinks plugin;
    ServerLinksReload(ServerLinks plugin) {
        plugin.getCommand("serverlinks").setExecutor(this);
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length == 0 || !args[0].equalsIgnoreCase("reload")) {
            sender.sendMessage("§cUsage: /serverlinks reload");
            return true;
        }
        this.plugin.reloadConfig();
        this.plugin.loadLinks();
        sender.sendMessage("§eServerLinks have been reloaded!");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return List.of("reload");
    }
}
