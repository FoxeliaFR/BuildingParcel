package fr.foxelia.buildingparcel.parcel;

import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.io.File;
import java.util.List;

public class ParcelGroup {

    private File folder;
    private ParcelConfig config;
    private String name;
    private String description = null;
    private String permission = null;
    private List<Parcel> parcels;

    public ParcelGroup(File folder) {
        this.folder = folder;
        if(folder.exists() && folder.isDirectory()) {
            boolean hasConfig = false;
            for(File file : folder.listFiles()) {
                if(file.getName().equalsIgnoreCase("config.yml")) {
                    hasConfig = true;
                    break;
                }
            }
            this.config = new ParcelConfig(folder.getName());
            if(hasConfig) {
                this.name = config.getConfig().getString("name");
                this.description = config.getConfig().getString("description");
                this.permission = config.getConfig().getString("permission");
            } else {
                config.getConfig().set("name", folder.getName());
            }

        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPermission() {
        return permission;
    }

    public List<Parcel> getParcels() {
        return parcels;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public void addParcel(Parcel parcel) {
        if(!parcels.contains(parcel)) parcels.add(parcel);
    }

    public void removeParcel(Parcel parcel) {
        if(parcels.contains(parcel)) parcels.remove(parcel);
    }

    public boolean hasPermission(Player player) {
        return permission == null || player.hasPermission(permission);
    }



}
