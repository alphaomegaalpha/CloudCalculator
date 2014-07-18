import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class CloudCalculator {

	String path;
	ArrayList<File> files;
	ArrayList<BufferedImage> images;
	int whitePx;
	double cloudyness;

	public CloudCalculator() {
	}

	public void scanFolder(String path) {
		this.path = path;
		File f = new File(path);
		File[] matchingFiles = f.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith("tiff");
			}
		});
		this.files = new ArrayList<File>(Arrays.asList(matchingFiles));
	}

	public void createImages() {
		for (File f : this.files) {
			try {
				BufferedImage img = ImageIO.read(new File(f.toString()));
				this.images.add(img);
			} catch (IOException e) {
			}
		}
	}

	public int calculateNumberOfWhitePixels() {
		int wp = 0;
		
		for(BufferedImage bi : this.images){
			
			
			Graphics2D g = bi.createGraphics();
			g.fill(polygon);
			g.dispose();
			countThePixels(bi);
			this.whitePx = wp;
			return wp;	
		}
		
	}
	
	public File writeCSV(String path){
		File f = new File(path);
		return f;
	}

	public void calculateCloudyness() {
		double c = 0;
		this.cloudyness = c;
	}

	public ArrayList<BufferedImage> getImgages() {
		return imgages;
	}

	public void setImgages(ArrayList<BufferedImage> imgages) {
		this.imgages = imgages;
	}

	public int getWhitePx() {
		return whitePx;
	}

	public void setWhitePx(int whitePx) {
		this.whitePx = whitePx;
	}

	public double getCloudyness() {
		return cloudyness;
	}

	public void setCloudyness(double cloudyness) {
		this.cloudyness = cloudyness;
	}

}
