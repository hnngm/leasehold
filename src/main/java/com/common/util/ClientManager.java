package com.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class ClientManager {

	private String charset="UTF-8";
	private DefaultHttpClient httpclient = null;

	public ClientManager() {
		httpclient = new DefaultHttpClient();
	}
	public ClientManager(String charset) {
		if (charset!=null&&!charset.equals("")) {
			this.charset=charset;
		}
		
		httpclient = new DefaultHttpClient();
	}

	public ClientManager(String proxyHost, Integer proxyPort,String charset) {
		if (charset!=null&&!charset.equals("")) {
			this.charset=charset;
		}
		httpclient = new DefaultHttpClient();
		httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,
				new HttpHost(proxyHost, proxyPort));

	}

	// get方式
	public String getMethod(String url) {
		String htmlString = "";
		try {
			HttpGet httpget = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			htmlString = EntityUtils.toString(entity,charset);
			EntityUtils.consume(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return htmlString;
	}

	// post方式
	public String postMethod(String url, Map<String, String> param) {

		String htmlString = "";
		try {

			HttpPost httpost = new HttpPost(url);
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			for (Map.Entry<String, String> entry : param.entrySet()) {
				nvps.add(new BasicNameValuePair(entry.getKey(), entry
						.getValue()));
			}

			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			HttpResponse response = httpclient.execute(httpost);
			HttpEntity entity = response.getEntity();
			String charset=getContentCharset(response);
			htmlString = EntityUtils.toString(entity,charset);
			EntityUtils.consume(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return htmlString;
	}

	// 关闭 httpClient
	public void close() {
		if (httpclient != null) {
			httpclient.getConnectionManager().shutdown();
		}
	}

	/**
	 * 正则匹配
	 * 
	 * @param s
	 * @param pattern
	 * @return
	 */
	public boolean matcher(String s, String pattern) {
		Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE
				+ Pattern.UNICODE_CASE);
		Matcher matcher = p.matcher(s);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获取Response内容字符集
	 * 
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public String getContentCharset(HttpResponse response) throws ParseException, IOException {
		String charset = "ISO_8859-1";
		HttpEntity  entity=response.getEntity();
		Header header = response.getEntity().getContentType();
		if (header != null) {
			
			String s = header.getValue();
			if (matcher(s, "(charset)\\s?=\\s?(utf-?8)")) {
				charset = "utf-8";
			} else if (matcher(s, "(charset)\\s?=\\s?(gbk)")) {
				charset = "gbk";
			} else if (matcher(s, "(charset)\\s?=\\s?(gb2312)")) {
				charset = "gb2312";
			}else{
				Pattern pattern=Pattern.compile("<meta[^>]*?charset=([a-z|A-Z|0-9]*[\\-]*[0-9]*)[\\s|\\S]*");
		        Matcher matcher=pattern.matcher(EntityUtils.toString(entity));
		        if(matcher.find()){
		        	charset=matcher.group(1);
		        }
			}
		}
		return charset;

	}
}
