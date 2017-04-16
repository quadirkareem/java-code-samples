package com.quadirkareem.tryouts;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestCJK {

	private static Logger logger = LoggerFactory.getLogger(TestCJK.class);
	
	private static final String CJK_FILE = "src/main/resources/CipherCloud_CJK_Range";
	private static final String CJK_OUT = "src/main/resources/cjkOut";
	
	private static final int WORD_SIZE = 10;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			List<String> lines = FileUtils.readLines(new File(CJK_FILE), StandardCharsets.UTF_8); 
			StringBuilder content = new StringBuilder(35000);
			StringBuilder word = new StringBuilder(WORD_SIZE);
			for(String l : lines) {
				if(word.length() <= WORD_SIZE) {
					word.append(l.charAt(0));
				}
				else {
					content.append(word);
					content.append(" ");
					word.delete(0, word.length());
				}
			}
			FileUtils.write(new File(CJK_OUT), content, StandardCharsets.UTF_8); 
			//logger.debug(content.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
