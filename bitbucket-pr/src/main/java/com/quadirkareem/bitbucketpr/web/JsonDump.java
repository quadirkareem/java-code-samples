package com.quadirkareem.bitbucketpr.web;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class JsonDump
 */
public class JsonDump extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory.getLogger(JsonDump.class);
	
	private static final String CRLF = "\r\n";
	private static final String PATH = "D:\\sandbox\\java\\com.sandbox.bitbucketjson\\src\\main\\resources\\";
	private static final String FILE_NAME = PATH + "dump.json";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		writeToFile(request.getReader());

		// TestJsonReading jsonReader = new TestJsonReading();
		// jsonReader.parseJson(inputStringBuilder.toString());
	}

	private void writeToFile(BufferedReader reader) {
		try {
			FileWriter fw = new FileWriter(FILE_NAME, true);
/*			LOG.info("Encoding: {}", fw.getEncoding());
			Path p = Paths.get(FILE_NAME);
			LOG.info("Absolute Path of {}: {}", FILE_NAME, p.toAbsolutePath());
			Path cur = Paths.get(".");
			LOG.info("Absolute Path of .: {}", cur.toAbsolutePath());*/
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				fw.append(line + CRLF);
				LOG.info("LINE: {}", line);
			}
			fw.append(CRLF + CRLF + "*******************************************" + CRLF + CRLF);
			fw.flush();
			fw.close();
		} catch (IOException io) {
			LOG.error("Error while writing to file {}", FILE_NAME, io);
		}
	}

}
