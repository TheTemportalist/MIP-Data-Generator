package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Main.MIP.MIPData;

import com.google.gson.Gson;

public class MIPDataGenerator {
	
	public static MIPDataGenerator instance;
	public final int width, height;
	public JPanel panel;
	
	public MIPDataGenerator() {
		this.width = 800;
		this.height = 600;
		
		JFrame frame = new JFrame("M.I.P. Data Generator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel = new Gui(this.width, this.height);
		
		frame.add(this.panel);
		frame.setSize(this.width, this.height);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	private final Gson gson = new Gson();
	private MIPData data;
	public String currentDataPluginID;
	
	public void setData(MIPData data) {
		this.data = data;
	}
	
	public MIPData getData() {
		return this.data;
	}
	
	public void openData(File file) {
		try {
			
			print("Reading data from JSON file");
			print("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
			this.setData(this.gson.fromJson(br, MIPData.class));
			
			this.currentDataPluginID = file.getName().substring(0, file.getName().lastIndexOf('.'));
			
			// print(this.currentDataPluginID + ":");
			// this.getData().print(this.gson);
			
			print("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			print("~~~~ Read sucessful ~~~~~~~");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void saveData(File file) {
		String jsonDataString = this.gson.toJson(this.getData());
		
		jsonDataString = JsonHelper.toReadableString(jsonDataString);
		
		FileWriter writer;
		try {
			file.createNewFile();
			
			print("Writing data to JSON file");
			print("~~~~~~~~~~~~~~~~~~~~~~~~~");
			writer = new FileWriter(file.getAbsolutePath());
			
			writer.write(jsonDataString);
			
			writer.close();
			
			print("~~~~~~~~~~~~~~~~~~~~~~~~~");
			print("~~~~ Write sucessful ~~~~");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void print(String str) {
		System.out.println(str);
	}
	
}
