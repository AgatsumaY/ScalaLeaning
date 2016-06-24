import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

class CodeToImage(val str: String) {
	def create(str: String) {
		val w = 60
		val h = 100
		val image = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
		val g2d = image.createGraphics();
		g2d.setBackground(Color.WHITE);
		g2d.clearRect(0,0,w,h);
		g2d.setColor(Color.BLACK);
		//後ほどforループでコードを書き直す
		g2d.drawString(str,0,17);
		g2d.drawString("bbb", 10, 25);
		//
		ImageIO.write(image, "JPEG", new File("/Users/kizer/scalaL/TestF/test1.jpg"));
	}
	def start() {
		create(str)
	}
}

object CodeToImage extends App {
	new CodeToImage("aaa").start
}