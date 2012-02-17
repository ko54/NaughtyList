package gmail.MinecraftMondaysDev.NaughtyList;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import gmail.MinecraftMondaysDev.NaughtyList.commands.NaughtyListAdd;
import gmail.MinecraftMondaysDev.NaughtyList.commands.NaughtyListCheck;
import gmail.MinecraftMondaysDev.NaughtyList.commands.NaughtyListRemove;

public class NaughtyList extends JavaPlugin {

	public final Logger logger = Logger.getLogger("Minecraft");
	protected FileConfiguration config;
	
	//Configuration Variables

	@Override
	public void onEnable() {
		
		//setup folders and files
		//getConfig();
		config = getConfig();
		
		if(!getDataFolder().exists()) {			
			System.out.print("[NaughtyList] Config folder not found! Creating...");
			getDataFolder().mkdir();
		}
		
		File configFile = new File(getDataFolder().getAbsolutePath() + File.separator + "config.yml");
		File watchListFile = new File(getDataFolder().getAbsolutePath() + File.separator + "watchlist.yml");
		
		if(!configFile.exists()) {
			System.out.print("[NaughtyList] Config File missing! Creating...");
			
			try {			
				configFile.createNewFile();
			} catch (IOException ex) {
				System.out.println("[NaughtyList] Failed to create file.");
			}
		}
		
		if(!watchListFile.exists()) {
			System.out.print("[NaughtyList] Watchlist File missing! Creating...");
			
			try {
				watchListFile.createNewFile();
			} catch (IOException ex) {
				System.out.println("[NaughtyList] Failed to create file.");
			}
			
		}
		
		//getCommand();
		
		getCommand("nla").setExecutor(new NaughtyListAdd(this));
		getCommand("nlr").setExecutor(new NaughtyListRemove(this));
		getCommand("nlc").setExecutor(new NaughtyListCheck(this));
		
		PluginDescriptionFile pdf = getDescription();
		this.logger.info(pdf.getName() + " Version: " + pdf.getVersion() + " has been enabled!");
	}

	@Override
	public void onDisable() {
		saveConfig();

		PluginDescriptionFile pdf = getDescription();
		this.logger.info(pdf.getName() + " Version: " + pdf.getVersion()
				+ " has been disabled!");

	}

}