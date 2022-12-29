package fr.foxelia.buildingparcel.parcel;

import fr.foxelia.buildingparcel.BuildingParcel;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;

public class ParcelConfig {

    private JavaPlugin plugin = BuildingParcel.getBuildingParcel();

    private FileConfiguration config;
    private File configFile;

    public ParcelConfig(String parcel) {
        this.configFile = new File(plugin.getDataFolder(), "parcels/" + parcel + "/config.yml");
        this.setupConfig();
    }

    private void setupConfig() {
        if(!(configFile.getParentFile().exists())) {
            try {
                configFile.getParentFile().mkdirs();
            } catch (Exception e) {
                Bukkit.getLogger().log(Level.SEVERE, "Cannot create parcel folder for " + configFile.getName() + ".");
                return;
            }
        }
        if(!configFile.exists()) {
            try {
                InputStream inputStream = this.plugin.getResource("defaultparcel.yml");
                config = YamlConfiguration.loadConfiguration(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                config.set("name", "parcel-" + System.currentTimeMillis());
                config.save(configFile);
            } catch(Exception e) {
                Bukkit.getLogger().log(Level.SEVERE, "Cannot generate default values for the " + configFile.getParentFile().getName() + " parcel!");
                e.printStackTrace();
            }
        } else {
            config = YamlConfiguration.loadConfiguration(configFile);
        }
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void saveConfig() {
        if(config != null && configFile != null)
            try {
                config.save(configFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void reloadConfig() {
        if(configFile.exists()) config = YamlConfiguration.loadConfiguration(configFile);
    }

}
