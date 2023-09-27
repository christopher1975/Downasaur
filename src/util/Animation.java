package util;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Animation {
    
	private List<BufferedImage> list;
	private long deltaTime; //deltaTime untuk memperbarui gerakan 
                                //sesuai dengan waktu yang telah berlalu
	private int currentFrame = 0;
	private long previousTime;
        //membuat animasi
	public Animation(int deltaTime) {
		this.deltaTime = deltaTime;
		list = new ArrayList<BufferedImage>();
		previousTime = 0;
	}
        //mengupdate frame
	public void updateFrame() {
		if (System.currentTimeMillis() - previousTime >= deltaTime) {
			currentFrame++;
			if (currentFrame >= list.size()) {
				currentFrame = 0;
			}
			previousTime = System.currentTimeMillis();
		}
	}
        //tambah frame
	public void addFrame(BufferedImage image) {
		list.add(image);
	}
        //mendapatkan frame
	public BufferedImage getFrame() {
		return list.get(currentFrame);
	}

}
