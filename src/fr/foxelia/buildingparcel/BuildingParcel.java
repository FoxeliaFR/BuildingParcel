package fr.foxelia.buildingparcel;

import fr.foxelia.buildingparcel.commands.ParcelCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class BuildingParcel extends JavaPlugin {

    private static BuildingParcel main;

    @Override
    public void onEnable() {
        main = this;
        getCommand("parcel").setExecutor(new ParcelCommand());
    }

    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    }

    public static BuildingParcel getBuildingParcel() {
        return main;
    }


}
