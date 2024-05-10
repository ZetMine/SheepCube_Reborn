package net.kubic.sheepcube;

import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public LuckPerms lpApi;
    private static Main instance;

    public static Plugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable(){

        instance = this;

        RegisteredServiceProvider<LuckPerms> lpProvider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (lpProvider != null) {
            lpApi = lpProvider.getProvider();
            getLogger().info("LuckPerms API loaded with success.");
        } else {
            getLogger().warning("LuckPerms API isn't found. Please make sure LuckPerms is downloaded.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }



    }
}