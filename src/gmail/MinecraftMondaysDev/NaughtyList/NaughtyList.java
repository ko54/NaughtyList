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

	public static String maindirectory = "plugins" + File.separator
			+ "NaughtyList";
	File nlConfig = new File(maindirectory + File.separator + "config.yml");
	File nlWatchList = new File(maindirectory + File.separator
			+ "watchlist.yml");
	public final Logger logger = Logger.getLogger("Minecraft");
	protected FileConfiguration config;

	// Configuration Variables

	@Override
	public void onEnable() {

		// setup folders and files
		// getConfig();

		if (!getDataFolder().exists()) {
			System.out
					.print("[NaughtyList] Config folder not found! Creating...");
			getDataFolder().mkdir();
		}

		if (!nlConfig.exists()) {
			System.out.print("[NaughtyList] Config File missing! Creating...");

			try {
				nlConfig.createNewFile();
			} catch (IOException ex) {
				System.out.println("[NaughtyList] Failed to create file.");
			}
		}

		if (!nlWatchList.exists()) {
			System.out
					.print("[NaughtyList] Watchlist File missing! Creating...");

			try {
				nlWatchList.createNewFile();
			} catch (IOException ex) {
				System.out.println("[NaughtyList] Failed to create file.");
			}

		}

		// getCommand();

		getCommand("nla").setExecutor(new NaughtyListAdd(this));
		getCommand("nlr").setExecutor(new NaughtyListRemove(this));
		getCommand("nlc").setExecutor(new NaughtyListCheck(this));
		getServer().getPluginManager().registerEvents(new LoginNotifier(this), this);
		

		PluginDescriptionFile pdf = getDescription();
		this.logger.info(pdf.getName() + " Version: " + pdf.getVersion()
				+ " has been enabled!");
	}

	@Override
	public void onDisable() {
		saveConfig();

		PluginDescriptionFile pdf = getDescription();
		this.logger.info(pdf.getName() + " Version: " + pdf.getVersion()
				+ " has been disabled!");

	}
}