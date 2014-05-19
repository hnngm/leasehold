package com.common.util;

import java.io.File;

/**
 * 目录/文件操作工具类
 * 
 * @author Administrator
 * 
 */
public class FileUtils {
	/**
	 * 删除文件夹的所有文件
	 * @param file
	 * @return
	 */
	public static boolean deleteFloderFile(File floder) {
		if (!floder.exists()) {
			return false;
		}
		File[] files = floder.listFiles();
		for (File deleteFile : files) {
			if (deleteFile.isDirectory()) {
				// 如果是文件夹，则递归删除下面的文件后再删除该文件夹
				if (!deleteFloderFile(deleteFile)) {
					// 如果失败则返回
					return false;
				}
			} else {
				if (!deleteFile.delete()) {
					// 如果失败则返回
					return false;
				}
			}
		}
		return floder.delete();
	}
}
