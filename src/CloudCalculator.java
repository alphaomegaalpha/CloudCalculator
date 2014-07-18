import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class CloudCalculator {

	String path;
	ArrayList<File> files;
	ArrayList<BufferedImage> images;
	HashMap<BufferedImage, String> imagecloud;
	int whitePx;
	double cloudyness;

	public CloudCalculator() {
	}

	public void scanFolder(String path) {
		this.path = path;
		File f = new File(path);
		File[] matchingFiles = f.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith("jpg");
			}
		});
		this.files = new ArrayList<File>();
		for (File fi : matchingFiles) {
			this.files.add(fi);
		}
	}

	public void createImages() {
		this.images = new ArrayList<BufferedImage>();
		for (File f : this.files) {
			try {
				BufferedImage img = ImageIO.read(f);
				this.images.add(img);
			} catch (IOException e) {
			}
		}
	}

	public void calculateCloudiness() {

		this.imagecloud = new HashMap<BufferedImage, String>();

		for (BufferedImage bi : this.images) {
			ArrayList<Integer> wp = new ArrayList<Integer>();
			int imgsz = bi.getWidth() * bi.getHeight();
			for (int i = 0; i < bi.getHeight(); ++i) {
				for (int j = 0; j < bi.getWidth(); ++j) {
					int color = bi.getRGB(j, i);
					if(color == (int)0xffffffff){
						wp.add(bi.getRGB(j, i));
					}
				}
			}
			double cloudiness = wp.size() / imgsz;
			System.out.println(String.valueOf(wp.size()));
			System.out.println(cloudiness);
			imagecloud.put(bi, String.valueOf(cloudiness));
		}
	}

	public File writeCSV(String path) {
		File f = new File(path);
		return f;
	}

	public ArrayList<BufferedImage> getImages() {
		return images;
	}

	public void setImgages(ArrayList<BufferedImage> images) {
		this.images = images;
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
