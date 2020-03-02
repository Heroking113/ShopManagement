package com.heroking.o2o.util;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import com.heroking.o2o.dto.ImageHolder;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * Description:
 * 
 * @author Heroking
 */
public class ImageUtil {
	/**
	 * 图片处理工具类
	 * 
	 * @throws IOException
	 **/

	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final java.text.SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random r = new Random();

	public static String generateThumbnail(ImageHolder thumbnail, String targetAddr) {
		String realFileName = getRandomFileName();
		String extension = getFileExtension(thumbnail.getImageName());
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		System.out.println("如果上传图片的时候报错：can't read input file，则检查一下ImageUtil.java文件下的basePath");
		System.out.println("basePath:"+basePath);
		try {
			Thumbnails.of(thumbnail.getImage()).size(200, 200)
					.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.75f)
					.outputQuality(0.8f).toFile(dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return relativeAddr;
	}
	
	public static String generateNormalImg(ImageHolder thumbnail, String targetAddr) {
		String realFileName = getRandomFileName();
		String extension = getFileExtension(thumbnail.getImageName());
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		System.out.println("如果上传图片的时候报错：can't read input file，则检查一下ImageUtil.java文件下的basePath");
		System.out.println("basePath:"+basePath);
		try {
			Thumbnails.of(thumbnail.getImage()).size(337, 640)
					.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.75f)
					.outputQuality(0.9f).toFile(dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return relativeAddr;
	}

	/**
	 * 路径拼接:/eclipse-workspace/o2oProjectDev/image/upload/images/item/shop/shopId/xxx.jpg
	 * 
	 * @param targetAddr
	 */
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}

	/**
	 * 获取图片扩展名
	 * 
	 * @param thumbnail
	 * @return
	 */
	private static String getFileExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * 生成随机数文件名
	 * 
	 * @return
	 */
	public static String getRandomFileName() {
		// 获取随机数
		int rannum = r.nextInt(89999) + 10000;
		String nowTimeStr = sDateFormat.format(new Date());
		return nowTimeStr + rannum;
	}

	/**
	 * 测试上传图片并加盖水印
	 */
	public static void main(String[] args) throws IOException {
		basePath = URLDecoder.decode(basePath, "utf-8");
		Thumbnails.of(new File("D:\\eclipse-workspace\\o2o\\target\\classes\\sea.jpg")).size(200, 200)
				.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "watermark.jpg")), 0.75f)
				.outputQuality(0.8f).toFile("D:\\eclipse-workspace\\o2o\\target\\classes\\sea_watermark.jpg");

	}
	
	/**
	 * 删除图片和路径
	 * @param storePath
	 * 
	 * */
	public static void deleteFileOrPath(String storePath) {
		File fileOrPath = new File(PathUtil.getImgBasePath()+storePath);
		if(fileOrPath.exists()) {
			if(fileOrPath.isDirectory()) {
				File files[] = fileOrPath.listFiles();
				for(int i=0;i<files.length;i++) {
					files[i].delete();
				}
			}
			fileOrPath.delete();
		}
	}
}
