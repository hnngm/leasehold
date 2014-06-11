package com.common.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

public class Helper {

	// 乱码处理
	public static String decode(String text) {
		if (text == null) {
			return null;
		}
		try {
			return URLDecoder.decode(text, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 乱码处理
	public static String encode(String text) {
		if (text == null) {
			return null;
		}
		try {
			return URLEncoder.encode(text, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 乱码处理
	public static String convertToChinese(String str) {
		if (str == null) {
			return null;
		}
		String keyword = null;
		try {
			if (str != null) {
				keyword = new String(str.getBytes("ISO-8859-1"), "utf-8");
			}
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		return keyword;
	}

	// 获得评论图标
	public static String criticismImage(int count) {
		String keyword = "";
		if (count == 0) {
			keyword = "<img  src='image/pingjia1.gif'/><img  src='image/pingjia1.gif'/><img  src='image/pingjia1.gif'/><img  src='image/pingjia1.gif'/><img  src='image/pingjia1.gif'/>";
		} else {
			for (int i = 0; i < 5; i++) {
				if ((i + 1) <= count) {
					keyword += "<img  src='image/pingjia2.gif'/>";
				} else {
					keyword += "<img  src='image/pingjia1.gif'/>";
				}
			}
		}

		return keyword;
	}

	// 去年html代码
	public static String deleteHtml(String content, int length, String str) {

		content = content.replaceAll("&nbsp;", "");
		content = content.replaceAll("\\<.*?>", "");
		if (length != 0) {
			if (content.length() > length) {
				content = content.substring(0, length) + str;
			}
		}
		return content;
	}

	// 获得日期
	public static String formatDate(String dateStr, int n) {

		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = myFormatter.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return myFormatter.format(new Date(date.getTime() + n * 24 * 60 * 60 * 1000));
	}

	// 返回文本by httprequest
	public static void backText(HttpServletResponse response, String data) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Writer out = response.getWriter();
		out.write(data);
		out.flush();
		out.close();
	}

	// 将日期转换成日期字符串
	public static String dateToString(Date date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(date);
	}

	public static void sendImage(HttpServletResponse response, BufferedImage image) {
		response.setDateHeader("Expires", 0);
		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");
		// return a jpeg
		response.setContentType("image/jpeg");

		ServletOutputStream out = null;
		try {
			out = response.getOutputStream();
			ImageIO.write(image, "jpg", out);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将bean对象转换成map
	 * @param bean
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static Map<String, Object> convertBeanToMap(Object bean) {
		Field[] fields = bean.getClass().getDeclaredFields();
		HashMap<String, Object> data = new HashMap<String, Object>();
		for (Field field : fields) {
			field.setAccessible(true);
			Object object;
			try {
				object = field.get(bean);
				if (object != null && !object.equals("")) {
					data.put(field.getName(), object);
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return data;
	}

	/**
	 * 获得登录用户
	 * @Title: getLoginUser 
	 * @Description: 
	 * @return  
	 * @author ning.han@baidao.com
	 */
	/*public static User getLoginUser() {
		Subject subject = SecurityUtils.getSubject();
		User loginUser = (User) subject.getPrincipal();
		return loginUser;
	}*/

	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	/**
	 * 复制文件
	 * @Title: copyFile 
	 * @Description: 
	 * @param srcFile
	 * @param destDir
	 * @param newFileName
	 * @return  
	 * @author ning.han@baidao.com
	 */
	public static long copyFile(File srcFile, File destDir, String newFileName) {
		long copySizes = 0;
		
			try {
				FileChannel fcin = new FileInputStream(srcFile).getChannel();
				FileChannel fcout = new FileOutputStream(new File(destDir, newFileName)).getChannel();
				long size = fcin.size();
				fcin.transferTo(0, fcin.size(), fcout);
				fcin.close();
				fcout.close();
				copySizes = size;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return copySizes;
	}

	//获得0-9A-Za-z的编码
	public static String createNum(String num) {
		
		char[] mums = num.toCharArray();
		int index=mums.length - 1;
		getNum(mums.length - 1, mums);
		return new String(mums);
	}

	private static void getNum(int index, char[] mums) {
		if (mums[index] == 'z') {
			mums[index] = '0';
			index--;
			if (index >= 0) {
				getNum(index, mums);
			}
		} else {
			mums[index] = getPosChar(mums[index]);

		}
	}

	private static char getPosChar(char currentChar) {
		char nextChar = 0;
		char[] data = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
				'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a',
				'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
				'v', 'w', 'x', 'y', 'z' };
		for (int i = 0; i < data.length; i++) {
			if (currentChar == data[i]) {
				nextChar = data[i + 1];
				break;
			}
		}
		return nextChar;
	}
}
