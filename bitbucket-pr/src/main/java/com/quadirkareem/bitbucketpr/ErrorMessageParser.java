package com.quadirkareem.bitbucketpr;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ErrorMessageParser {

	private static final Logger LOG = LoggerFactory
			.getLogger(PullRequestParser.class);

	private static final String PR_CREATED = "pullrequest_created";

	private static final String PR_UPDATED = "pullrequest_updated";

	private static final String PR_COMMENT_CREATED = "pullrequest_comment_created";

	private static final String STATE_OPEN = "OPEN";

	private static final String CREATED_JSON = "pr_created.json";
	
	private static final String UPDATED_JSON = "pr_updated.json";
	
	private static final String COMMENT_CREATED_JSON = "pr_comment_created.json";
	
	private static final String ERROR_JSON = "error.json";
	
	private static final Pattern COMMENT_URL_PATTERN = Pattern.compile("https://api.bitbucket.org/2.0/repositories/[^\\s]+/pullrequests/\\d+");

	public static void main(String[] args) throws IOException {
		ErrorMessageParser jsonReader = new ErrorMessageParser();
		InputStream jsonStream = jsonReader.getJsonStream(ERROR_JSON);
		jsonReader.getErrorMessage(IOUtils.toString(jsonStream, StandardCharsets.UTF_8));
		//LOG.info("{}", "\r\n\r\n");
		/*
		jsonStream = jsonReader.getJsonStream(UPDATED_JSON);
		jsonReader.parseJson(jsonStream);
		LOG.info("{}", "\r\n\r\n");
		
		jsonStream = jsonReader.getJsonStream(COMMENT_CREATED_JSON);
		jsonReader.parseJson(jsonStream);
		LOG.info("{}", "\r\n\r\n");
		*/
		// jsonReader.domReader(jsonStream);
		// logger.info("Json Data: {}", jsonReader.readJson());
	}

	public InputStream getJsonStream(String filename) throws IOException {
		String jsonData = null;
		ClassLoader classLoader = this.getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(filename);
		// jsonData = IOUtils.toString(inputStream);

		return inputStream;
	}
/*
	public void parseJson(String jsonString) 
			throws JsonParseException, IOException {
		JsonFactory jsonFactory = new JsonFactory();
		JsonParser jp = jsonFactory.createParser(jsonString);
		streamReader(jp);
	}
	
	private void parseJson(InputStream inputStream) 
			throws JsonParseException, IOException {
		JsonFactory jsonFactory = new JsonFactory();
		JsonParser jp = jsonFactory.createParser(inputStream);
		streamReader(jp);
	}
	*/
	private String getErrorMessage(String response) throws IOException {
		String errorMessage = null;
		JsonFactory jsonFactory = new JsonFactory();
		JsonParser parser = jsonFactory.createParser(response);
		ObjectMapper mapper = new ObjectMapper();
		while (parser.nextToken() != null) {
			JsonToken token = parser.nextToken();
			if (token != null) {
				JsonNode root = ((JsonNode) mapper.readTree(parser))
						.path("error");
				errorMessage = root.path("fields").path("newstatus").path(0).asText();
				LOG.info("***** ERROR MESSAGE *****");
				LOG.info(errorMessage);
				break;
			}
		}
		parser.close();
		return errorMessage;
	}
	
	/*
	private void streamReader(JsonParser jp)
			throws JsonParseException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		while (jp.nextToken() != null) {
			JsonToken jt = jp.nextToken();
			if (jt != null) {
				String fieldName = jp.getCurrentName();
				if (PullRequestParser.PR_CREATED.equalsIgnoreCase(fieldName)) {
					JsonNode root = ((JsonNode) mapper.readTree(jp))
							.path(PullRequestParser.PR_CREATED);
					LOG.info("***** PULL REQUEST CREATED *****");
					LOG.info("Pull Request id = {}", getId(root));
					LOG.info("Self Url = {}", getSelfUrl(root));
					LOG.info("Source Repository = {}",
							getSourceRepository(root));
					LOG.info("Source Branch = {}", getSourceBranch(root));
					LOG.info("Destination Repository = {}",
							getDestinationRepository(root));
					LOG.info("Destination Branch = {}",
							getDestinationBranch(root));
					LOG.info("is Open = {}", isOpen(root));
				}
				else if(PullRequestParser.PR_UPDATED.equalsIgnoreCase(fieldName)) {
					JsonNode root = ((JsonNode) mapper.readTree(jp))
							.path(PullRequestParser.PR_UPDATED);
					LOG.info("***** PULL REQUEST UPDATED *****");
					LOG.info("Source Repository = {}",
							getSourceRepository(root));
					LOG.info("Source Branch = {}", getSourceBranch(root));
					LOG.info("Destination Repository = {}",
							getDestinationRepository(root));
					LOG.info("Destination Branch = {}",
							getDestinationBranch(root));
					LOG.info("is Open = {}", isOpen(root));
				}
				else if(PullRequestParser.PR_COMMENT_CREATED.equalsIgnoreCase(fieldName)) {
					JsonNode root = ((JsonNode) mapper.readTree(jp))
							.path(PullRequestParser.PR_COMMENT_CREATED);
					LOG.info("***** PULL REQUEST COMMENT CREATED *****");
					LOG.info("is Open = {}", isOpen(root));
					LOG.info("Raw Comment = {}",
							getRawComments(root));
					String commentsUrl = getSelfUrl(root);
					LOG.info("Self Url = {}", commentsUrl);
					LOG.info("Pull Request Url = {}", getPullRequestUrl(commentsUrl));
				}
				
				// logger.info("currentName = {}; type = {}", fieldName,
				// jt.name());
			}
		}
		jp.close();
	}
	

	private String getDestinationBranch(JsonNode root) {
		return root.path("destination").path("branch").path("name").textValue();
	}

	private String getDestinationRepository(JsonNode root) {
		return root.path("destination").path("repository").path("full_name")
				.textValue();
	}

	private String getSourceBranch(JsonNode root) {
		return root.path("source").path("branch").path("name").textValue();
	}

	private String getSourceRepository(JsonNode root) {
		return root.path("source").path("repository").path("full_name")
				.textValue();
	}

	private String getCommentsUrl(JsonNode root) throws IOException {
		return root.path("links").path("comments").path("href").textValue();
	}
	
	private String getSelfUrl(JsonNode root) throws IOException {
		return root.path("links").path("self").path("href").textValue();
	}
	
	private String getRawComments(JsonNode root) throws IOException {
		return root.path("content").path("raw").textValue();
	}

	private String getId(JsonNode root) throws IOException {
		return root.path("id").asText();
	}
	
	private boolean isOpen(JsonNode root) throws IOException {
		return STATE_OPEN.equalsIgnoreCase(root.path("state").asText());
	}
	
	private String getPullRequestUrl(String commentsUrl) {
		String pullRequestUrl = null;
		Matcher m = COMMENT_URL_PATTERN.matcher(commentsUrl);
		if(m.find()) {
			pullRequestUrl = m.group();
		}
		return pullRequestUrl;
	}
	*/
}
