package fr.foxelia.buildingparcel.parcel;

import fr.foxelia.buildingparcel.tools.WorldEditSchematic;

import java.io.File;

public class Parcel {

    private File file;
    private ParcelRequierement requierement;
    private WorldEditSchematic schematic;

    public Parcel(File file, ParcelRequierement requierement) {
        this.file = file;
        this.requierement = requierement;
        this.schematic = new WorldEditSchematic();
        reloadSchematic();
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public ParcelRequierement getRequierement() {
        return requierement;
    }

    public void setRequierement(ParcelRequierement requierement) {
        this.requierement = requierement;
    }

    public WorldEditSchematic getSchematic() {
        return schematic;
    }

    public void reloadSchematic() {
        schematic.loadSchematic(file);
    }

}
