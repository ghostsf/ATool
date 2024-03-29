package com.ghostsf.atool.captcha;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

import com.ghostsf.atool.util.ImageUtil;
import com.ghostsf.atool.util.RandomUtil;

/**
 * 使用干扰线方式生成的图形验证码
 * 
 * @author ghostsf
 * @since 3.1.2
 */
public class LineCaptcha extends AbstractCaptcha {
	private static final long serialVersionUID = 8691294460763091089L;

	// -------------------------------------------------------------------- Constructor start
	/**
	 * 构造，默认4位验证码，150条干扰线
	 * 
	 * @param width 图片宽
	 * @param height 图片高
	 */
	public LineCaptcha(int width, int height) {
		this(width, height, 5, 150);
	}

	/**
	 * 构造
	 * 
	 * @param width 图片宽
	 * @param height 图片高
	 * @param codeCount 字符个数
	 * @param lineCount 干扰线条数
	 */
	public LineCaptcha(int width, int height, int codeCount, int lineCount) {
		super(width, height, codeCount, lineCount);
	}
	// -------------------------------------------------------------------- Constructor end

	@Override
	public void createImage(String code) {
		// 图像buffer
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		final ThreadLocalRandom random = RandomUtil.getRandom();
		final Graphics2D g = ImageUtil.createGraphics(this.image, ImageUtil.randomColor(random));
		// 创建字体
		g.setFont(this.font);

		// 干扰线
		drawInterfere(g, random);

		// 文字
		int charWidth = width / (codeCount + 2);
		for (int i = 0; i < codeCount; i++) {
			// 产生随机的颜色值，让输出的每个字符的颜色值都将不同。
			g.setColor(ImageUtil.randomColor(random));
			g.drawString(String.valueOf(code.charAt(i)), i * charWidth + (charWidth >> 1), RandomUtil.randomInt(height >> 1) + (height >> 1));
		}
	}

	// ----------------------------------------------------------------------------------------------------- Private method start
	/**
	 * 绘制干扰线
	 * 
	 * @param g {@link Graphics2D}画笔
	 * @param random 随机对象
	 */
	private void drawInterfere(Graphics2D g, ThreadLocalRandom random) {
		// 干扰线
		for (int i = 0; i < this.interfereCount; i++) {
			int xs = random.nextInt(width);
			int ys = random.nextInt(height);
			int xe = xs + random.nextInt(width / 8);
			int ye = ys + random.nextInt(height / 8);
			g.setColor(ImageUtil.randomColor(random));
			g.drawLine(xs, ys, xe, ye);
		}
	}
	// ----------------------------------------------------------------------------------------------------- Private method start
}