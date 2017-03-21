package com.balazstorok.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Resource handler utility class.
 * <p/>
 * Created by Balazs Torok on 13/02/17.
 */
public final class ResourceUtil {

	/**
	 * Helper method to return file content from the classpath.
	 *
	 * @param filePath the path of the file on the classpath
	 * @return the content of the file as String
	 */
	public static String getFileContent(String filePath) {
		InputStream in = ResourceUtil.class.getResourceAsStream(filePath);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		return reader.lines().collect(Collectors.joining());
	}
}
