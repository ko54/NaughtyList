package gmail.MinecraftMondaysDev.NaughtyList;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import gmail.MinecraftMondaysDev.NaughtyList.commands.NaughtyListCmd;

public class NaughtyList extends JavaPlugin {

	public String colorGold = ChatColor.GOLD.toString();
	public String colorDarkRed = ChatColor.DARK_RED.toString();
	public final Logger logger = Logger.getLogger("Minecraft");

	@Override
	public void onEnable() {

		PluginDescriptionFile pdf = getDescription();
		this.logger.info(pdf.getName() + " Version: " + pdf.getVersion() + " has been enabled!");
		
		//setup folders and files
		//soon
		
		getCommand("nl").setExecutor(new NaughtyListCmd(this));
	}

	@Override
	public void onDisable() {

		PluginDescriptionFile pdf = getDescription();
		this.logger.info(pdf.getName() + " Version: " + pdf.getVersion() + " has been disabled!");

	}
}