package de.hirnmoritz.main.messages;

import de.hirnmoritz.main.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class I18nUtil
{
    static FileConfiguration l;
    public static String lang="en_US";

    public static void setLanguage(String language)
    {
        if(lang.equals("")) return;
        lang=language;
        File langFile = new File(Main.getMain().getDataFolder(), "lang_"+lang+".yml");
        if (!langFile.exists()) Main.getMain().saveResource("lang_"+lang+".yml", false);
        l = YamlConfiguration.loadConfiguration(langFile);
    }
    public static String getLocalizedMessage(String key){return l.getString(key);}
    public String getLanguage(){return lang;}
}
