package com.hc.rest.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageUtils {

	private static Logger log = LoggerFactory.getLogger(ImageUtils.class);
	// 图片的宽度。
	private int width = 160;
	// 图片的高度。
	private int height = 40;
	// 验证码字符个数
	private int codeCount = 5;
	// 验证码干扰线数
	private int lineCount = 150;
	// 验证码
	private String code = null;
	// 验证码图片Buffer
	private BufferedImage buffImg = null;

	private char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public ImageUtils() {
		this.createCode();
	}

	/**
	 * 
	 * @param width
	 *            图片宽
	 * @param height
	 *            图片高
	 */
	public ImageUtils(int width, int height) {
		this.width = width;
		this.height = height;
		this.createCode();
	}

	/**
	 * 
	 * @param width
	 *            图片宽
	 * @param height
	 *            图片高
	 * @param codeCount
	 *            字符个数
	 * @param lineCount
	 *            干扰线条数
	 */
	public ImageUtils(int width, int height, int codeCount, int lineCount) {
		this.width = width;
		this.height = height;
		this.codeCount = codeCount;
		this.lineCount = lineCount;
		this.createCode();
	}

	public void createCode() {
		int x = 0, fontHeight = 0, codeY = 0;
		int red = 0, green = 0, blue = 0;

		x = width / (codeCount + 2);// 每个字符的宽度
		fontHeight = height - 2;// 字体的高度
		codeY = height - 4;

		// 图像buffer
		buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		// 生成随机数
		Random random = new Random();
		// 将图像填充为白色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// 创建字体
		Font font = getFont(fontHeight);
		g.setFont(font);

		for (int i = 0; i < lineCount; i++) {
			int xs = random.nextInt(width);
			int ys = random.nextInt(height);
			int xe = xs + random.nextInt(width / 8);
			int ye = ys + random.nextInt(height / 8);
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			g.setColor(new Color(red, green, blue));
			g.drawLine(xs, ys, xe, ye);
		}

		// randomCode记录随机产生的验证码
		StringBuffer randomCode = new StringBuffer();
		// 随机产生codeCount个字符的验证码。
		for (int i = 0; i < codeCount; i++) {
			String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
			// 产生随机的颜色值，让输出的每个字符的颜色值都将不同。
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			g.setColor(new Color(red, green, blue));
			g.drawString(strRand, (i + 1) * x, codeY);
			// 将产生的四个随机数组合在一起。
			randomCode.append(strRand);
		}
		// 将四位数字的验证码保存到Session中。
		code = randomCode.toString();
		log.info("ImageCode:{}", code);
	}

	public void write(String path) throws IOException {
		OutputStream sos = new FileOutputStream(path);
		this.write(sos);
	}

	public void write(OutputStream sos) throws IOException {
		ImageIO.write(buffImg, "png", sos);
		sos.close();
	}

	public BufferedImage getBuffImg() {
		return buffImg;
	}

	public String getCode() {
		return code;
	}

	/**
	 * ttf字体文件的十六进制字符串
	 * 
	 * @return
	 */
	private String getFontByteStr() {
		return null;
	}

	private Font getFont(int fontHeight) {
		try {
			Font baseFont = Font.createFont(Font.TRUETYPE_FONT, new ByteArrayInputStream(hex2byte(getFontByteStr())));
			return baseFont.deriveFont(Font.PLAIN, fontHeight);
		} catch (Exception e) {
			return new Font("Arial", Font.PLAIN, fontHeight);
		}
	}

	private byte[] hex2byte(String str) {
		if (str == null)
			return null;
		str = str.trim();
		int len = str.length();
		if (len == 0 || len % 2 == 1)
			return null;

		byte[] b = new byte[len / 2];
		try {
			for (int i = 0; i < str.length(); i += 2) {
				b[i / 2] = (byte) Integer.decode("0x" + str.substring(i, i + 2)).intValue();
			}
			return b;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 根据图片文件路径转换为base64字符串
	 * 
	 * @param imageFile
	 * @return
	 */
	public static String imageToBase64(String imageFile) {
		InputStream inputStream = null;
		byte[] data = null;
		try {
			inputStream = new FileInputStream(imageFile);
			data = new byte[inputStream.available()];
			inputStream.read(data);
			inputStream.close();
		} catch (IOException e) {
			log.error("读取图形文件异常：", e);
		}
		String imageBase64 = new String(Base64.encodeBase64(data));
		return imageBase64;
	}

	/**
	 * 根据图片二进制流转换为base64加密后的字符串
	 * 
	 * @param inputStream
	 * @return
	 */
	public static String imageToBase64(InputStream inputStream) {
		byte[] data = null;
		try {
			data = new byte[inputStream.available()];
			inputStream.read(data);
			inputStream.close();
		} catch (IOException e) {
			log.error("读取图形文件异常：", e);
		}
		String imageBase64 = new String(Base64.encodeBase64(data));
		return imageBase64;
	}

	public static String imageToBase64(byte[] data) {
		String imageBase64 = new String(Base64.encodeBase64(data));
		return imageBase64;
	}

	/**
	 * Base64加密后的图片数据转化为图片
	 * 
	 * @param base64Str
	 *            图片Base64加密后的数据
	 * @param path
	 *            需要转化图片的路径加文件名
	 * @return
	 */
	public static boolean base64ToImage(String base64Str, String path) {
		if (base64Str == null || "".equals(base64Str)) {
			return false;
		}
		try {
			byte[] b = Base64.decodeBase64(base64Str);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			OutputStream out = new FileOutputStream(path);
			out.write(b);
			out.flush();
			out.close();
		} catch (Exception e) {
			log.error("图片base64加密字符串转图片异常：", e);
			return false;
		}
		return true;
	}

	/**
	 * Base64加密后的图片数据转化为二进制
	 * 
	 * @param base64Str
	 * @return
	 */
	public static byte[] base64ToImage(String base64Str) {
		if (base64Str == null || "".equals(base64Str)) {
			return null;
		}
		try {
			byte[] b = Base64.decodeBase64(base64Str);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			return b;
		} catch (Exception e) {
			log.error("图片base64加密字符串转图片异常：", e);
			return null;
		}
	}

	public static void main(String[] args) {
		String data = imageToBase64("/face.jpg");
		String path = "/temp.jpg";
		System.out.println(base64ToImage(data, path));
	}
}
