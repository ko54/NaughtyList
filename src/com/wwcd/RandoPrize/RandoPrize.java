package com.wwcd.RandoPrize;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.wwcd.RandoPrize.commands.*;

public class RandoPrize extends JavaPlugin {

	public static String maindirectory = "plugins" + File.separator
			+ "RandoPrize";
	File rpConfig = new File(maindirectory + File.separator + "config.yml");
	File rpHash = new File(maindirectory + File.separator + "hashDONTTOUCH.yml");
	public final Logger logger = Logger.getLogger("Minecraft");
	public FileConfiguration config;
	public int tid = 0;
	public int running = 1;
	public int interval = 0;
	public int status = 0;
	public String hash = null;
	public Thread run = null;
	public RandoPrizeUse rpu = null;

	// Configuration Variables

	@Override
	public void onEnable() {
		
		rpu = new RandoPrizeUse(this);
		
		if (!getDataFolder().exists()) {
			System.out
					.print("[RandoPrize] Config folder not found! Creating...");
			getDataFolder().mkdir();
		}
		
		if(!rpHash.exists())
		{
			System.out.print("[RandoPrize] Hash File missing! Creating...");
			try
			{
				rpHash.createNewFile();
			}
			catch(IOException ex)
			{
				System.out.print("[RandoPrize] Failed to create file.");
			}
		}

		if (!rpConfig.exists()) {
			System.out.print("[RandoPrize] Config File missing! Creating...");

			try {
				rpConfig.createNewFile();
				getConfig().options().copyDefaults(true);
			} catch (IOException ex) {
				System.out.println("[RandoPrize] Failed to create file.");
			}
		}
		
		getCommand("rpo").setExecutor(new RandoPrizeCommand(this));
		getCommand("rp").setExecutor(new RandoPrizeUse(this));
		
		interval = this.getConfig().getInt("prize-timer");

		PluginDescriptionFile pdf = getDescription();
		this.logger.info(pdf.getName() + " Version: " + pdf.getVersion()
				+ " has been enabled!");
		
		tid = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				setHashString();
				hash = getHashString();
				rpu.resetStatus();
				Bukkit.broadcastMessage("[RandoPrize] Use </rp " + hash + "> to recieve a prize!");
			}
		}, 0, interval*20);
	}

	@Override
	public void onDisable() {
		saveConfig();
		Bukkit.getScheduler().cancelTask(tid);
		
		PluginDescriptionFile pdf = getDescription();
		this.logger.info(pdf.getName() + " Version: " + pdf.getVersion()
				+ " has been disabled!");

	}
	
	public void reload()
	{
		PluginDescriptionFile pdf = getDescription();
		this.logger.info("[RandoPrize] Disabling " + pdf.getName());
		onDisable();
		this.logger.info("[RandoPrize] Enabling " + pdf.getName());
		onEnable();
	}
	
	public void silentReload()
	{
		onDisable();
		onEnable();
	}
	public String getHashString()
	{
		String temp = "";
		try {
			temp = readFile(rpHash);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public void setHashString()
	{
		String temp = buildRandomString();
		try {
			setHashFile(temp, rpHash);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String readFile( File file ) throws IOException {
	    BufferedReader reader = new BufferedReader( new FileReader (file));
	    String line  = null;
	    StringBuilder stringBuilder = new StringBuilder();
	    while( ( line = reader.readLine() ) != null ) {
	        stringBuilder.append( line );
	    }
	    return stringBuilder.toString();
	 }
	
	private void setHashFile(String in, File file) throws IOException
	{
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
		out.write(in);
		out.close();
	}

	
  	public String buildRandomString() {
		Random rd = new Random();
		String temp = "";
		for (int i = 0; i < Integer.parseInt(this.getConfig().getString("prize-hash")); i++) {
			int letter = rd.nextInt(63);
			
			switch (letter) {
			case 0:
				temp += 'a';
				break;
			case 1:
				temp += 'b';
				break;
			case 2:
				temp += 'c';
				break;
			case 3:
				temp += 'd';
				break;
			case 4:
				temp += 'e';
				break;
			case 5:
				temp += 'f';
				break;
			case 6:
				temp += 'g';
				break;
			case 7:
				temp += 'h';
				break;
			case 8:
				temp += 'i';
				break;
			case 9:
				temp += 'j';
				break;
			case 10:
				temp += 'k';
				break;
			case 11:
				temp += 'l';
				break;
			case 12:
				temp += 'm';
				break;
			case 13:
				temp += 'n';
				break;
			case 14:
				temp += 'o';
				break;
			case 15:
				temp += 'p';
				break;
			case 16:
				temp += 'q';
				break;
			case 17:
				temp += 'r';
				break;
			case 18:
				temp += 's';
				break;
			case 19:
				temp += 't';
				break;
			case 20:
				temp += 'u';
				break;
			case 21:
				temp += 'v';
				break;
			case 22:
				temp += 'w';
				break;
			case 23:
				temp += 'x';
				break;
			case 24:
				temp += 'y';
				break;
			case 25:
				temp += 'z';
				break;
			case 26:
				temp += 'A';
				break;
			case 27:
				temp += 'B';
				break;
			case 28:
				temp += 'C';
				break;
			case 29:
				temp += 'D';
				break;
			case 30:
				temp += 'E';
				break;
			case 31:
				temp += 'F';
				break;
			case 32:
				temp += 'G';
				break;
			case 33:
				temp += 'H';
				break;
			case 34:
				temp += 'I';
				break;
			case 35:
				temp += 'J';
				break;
			case 36:
				temp += 'K';
				break;
			case 37:
				temp += 'L';
				break;
			case 38:
				temp += 'M';
				break;
			case 39:
				temp += 'N';
				break;
			case 40:
				temp += 'O';
				break;
			case 41:
				temp += 'P';
				break;
			case 42:
				temp += 'Q';
				break;
			case 43:
				temp += 'R';
				break;
			case 44:
				temp += 'S';
				break;
			case 45:
				temp += 'T';
				break;
			case 46:
				temp += 'U';
				break;
			case 47:
				temp += 'V';
				break;
			case 48:
				temp += 'W';
				break;
			case 49:
				temp += 'X';
				break;
			case 50:
				temp += 'Y';
				break;
			case 51:
				temp += 'Z';
				break;
			case 52:
				temp += '0';
				break;
			case 53:
				temp += '1';
				break;
			case 54:
				temp += '2';
				break;
			case 55:
				temp += '3';
				break;
			case 56:
				temp += '4';
				break;
			case 57:
				temp += '5';
				break;
			case 58:
				temp += '6';
				break;
			case 59:
				temp += '7';
				break;
			case 60:
				temp += '8';
				break;
			case 61:
				temp += '9';
				break;
			default:
				temp += 'a';
				break;
			}
		}
		return temp;
	}
}