package fr.foxelia.buildingparcel.commands;

import fr.foxelia.buildingparcel.BuildingParcel;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;

public class ParcelCommand implements CommandExecutor {

    public static String playerPermission = "buildingparcel.player";
    public static String adminPermission = "buildingparcel.admin";

    public ParcelCommand() {
        BuildingParcel.getBuildingParcel().getCommand("parcel").setTabCompleter(new ParcelCommandCompleter());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        return false;
    }

}

class ParcelCommandCompleter implements TabCompleter {

    @Override
    public java.util.List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        ArrayList<String> suggest = new ArrayList<>();
        return suggest;
    }

}
