package edu.arizona.ece373.InterplanetaryPioneers.Controller;

import java.io.File;

public class SongPath{
	
	public static String getPath(int songNumber){
		
		File currentDirFile = new File(".");
		
		String ProjectFolder = System.getProperty("user.dir"); 
		
		switch (songNumber) {
			case 0:
				return "lib/sounds/01 - Stellaris Suite_ Creation and Beyond.mp3";
				//return ProjectFolder + "\\lib\\sounds\\01 - Stellaris Suite_ Creation and Beyond.mp3";
			case 1:
				//return ProjectFolder + "\\lib\\sounds\\02 - Deep Space Travels.mp3";
				return "lib/sounds/02 - Deep Space Travels.mp3";
			case 2:
				//return ProjectFolder + "\\lib\\sounds\\02 - Deep Space Travels.mp3";
				return "lib/sounds/02 - Deep Space Travels.mp3";
			case 3:
				//return ProjectFolder + "\\lib\\sounds\\03 - To the End of the Galaxy.mp3";
				return "lib/sounds/03 - To the End of the Galaxy.mp3";
			case 4:
				//return ProjectFolder + "\\lib\\sounds\\04 - In Search of Life.mp3";
				return "lib/sounds/04 - In Search of Life.mp3";
			case 5:
				//return ProjectFolder + "\\lib\\sounds\\05 - Spatial Lullaby.mp3";
				return "lib/sounds/05 - Spatial Lullaby.mp3";
			case 6:
				//return ProjectFolder + "\\lib\\sounds\\06 - Gravitational Constant.mp3";
				return "lib/sounds/06 - Gravitational Constant.mp3";
			case 7:
				//return ProjectFolder + "\\lib\\sounds\\07 - Alpha Centauri.mp3";
				return "lib/sounds/07 - Alpha Centauri.mp3";
			case 8:
				//return ProjectFolder + "\\lib\\sounds\\08 - Genesis.mp3";
				return "lib/sounds/08 - Genesis.mp3";
			case 9:
				//return ProjectFolder + "\\lib\\sounds\\09 - The Celestial City.mp3";
				return "lib/sounds/09 - The Celestial City.mp3";
			case 10:
				//return ProjectFolder + "\\lib\\sounds\\10 - Infinite Being.mp3";
				return "lib/sounds/10 - Infinite Being.mp3";
			case 11:
				//return ProjectFolder + "\\lib\\sounds\\11 - Pillars of Creation.mp3";
				return "lib/sounds/11 - Pillars of Creation.mp3";
			case 12:
				//return ProjectFolder + "\\lib\\sounds\\12 - Distant Nebula.mp3";
				return "lib/sounds/12 - Distant Nebula.mp3";
			case 13:
				//return ProjectFolder + "\\lib\\sounds\\13 - Sigmatauri.mp3";
				return "lib/sounds/13 - Sigmatauri.mp3";
			case 14:
				//return ProjectFolder + "\\lib\\sounds\\14 - Journey Beyond the Galaxy.mp3";
				return "lib/sounds/14 - Journey Beyond the Galaxy.mp3";
			case 15:
				//return ProjectFolder + "\\lib\\sounds\\15 - Riding the Solar Wind.mp3";
				return "lib/sounds/15 - Riding the Solar Wind.mp3";
			case 16:
				//return ProjectFolder + "\\lib\\sounds\\16 - The Birth of a Star.mp3";
				return "lib/sounds/16 - The Birth of a Star.mp3";
			case 17:
				//return ProjectFolder + "\\lib\\sounds\\17 - Luminescence.mp3";
				return "lib/sounds/17 - Luminescence.mp3";
			case 18:
				//return ProjectFolder + "\\lib\\sounds\\18 - Faster Than Light (Instrumental).mp3";
				return "lib/sounds/18 - Faster Than Light (Instrumental).mp3";
			case 19:
				//return ProjectFolder + "\\lib\\sounds\\241262_lewis100011_sci-fi-engine.mp3";
				return "lib/sounds/241262_lewis100011_sci-fi-engine.mp3";
			case 20:
				//return ProjectFolder + "\\lib\\sounds\\34203_themfish_power-down.mp3";
				return "lib/sounds/34203_themfish_power-down.mp3";
			case 21:
				//return ProjectFolder + "\\lib\\sounds\\322898_rhodesmas_ui-02.mp3";
				return "lib/sounds/322898_rhodesmas_ui-02.mp3";
			case 22:
				//return ProjectFolder + "\\lib\\sounds\\271287_spinozz_distorted-neuro-electro-basse.mp3";
				return "lib/sounds/271287_spinozz_distorted-neuro-electro-basse.mp3";
			case 23:
				//return ProjectFolder + "\\lib\\sounds\\19 Running Out.mp3";
				return "lib/sounds/19 Running Out.mp3";
			case 24:
				//return ProjectFolder + "\\lib\\sounds\\345271_soneproject_ecofuture2.mp3";
				return "lib/sounds/345271_soneproject_ecofuture2.mp3";
			case 25:
				//return ProjectFolder + "\\lib\\sounds\\gameaudio_win-spacey.mp3";
				return "lib/sounds/gameaudio_win-spacey.mp3";
			case 26:
				//return ProjectFolder + "\\lib\\sounds\\pera_introgui.mp3";
				return "lib/sounds/pera_introgui.mp3";
		}
		
		return null;
	}

}
