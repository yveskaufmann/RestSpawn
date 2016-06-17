package de.yveskaufmann.restspawn.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicLineFormatter;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import static java.text.MessageFormat.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;



/**
 * A template for a rest client implementation.
 *
 * @author Yves Kaufmann
 */
public class TemplateApi {

	private final Logger Log = LoggerFactory.getLogger(TemplateApi.class);

	/******************************************************************************
	 *
	 * Fields
	 *
	 ******************************************************************************/

	/**
	 * A jackson object mapper for de/serialization of model POJOs
	 */
	private ObjectMapper objectMapper;

	/**
	 * The format which is used to format Date objects and so on.
	 */
	private DateFormat dateFormat;

	/******************************************************************************
	 * Constructors
	 ******************************************************************************/

	public TemplateApi() {
		objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
		objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
		objectMapper.setDateFormat(buildDefaultFormat());
		objectMapper.registerModules(new Jdk8Module());
		objectMapper.registerModules(new JavaTimeModule());
	}

	/******************************************************************************
	 * Public API
	 ******************************************************************************/

	// TODO: params passing
	// TODO: put, delete, post, etc.
	// TODO: auth
	// TODO: valud

	public <T> T fetchObject(String url, Class<T> type) {
		Objects.requireNonNull(type, "A type must provided");
		Log.info("fetch {} object GET /{}", type.getSimpleName(), url);
		try {
			T result =
				createGetRequest(url)
				.execute()
				.handleResponse(createResponseHandler(new TypeReference<T>() {
					@Override
					public Type getType() {
						return type;
					}
				}));
			Log.info("Received 1 entry of {}", type.getSimpleName());
			return result;
		} catch (IOException e) {
			Log.error(format("Failed to fetch {0} object from {1}", type.getSimpleName(), url), e);
		}
		Log.info("Received no entry of {}", type.getSimpleName());
		return null;
	}

	public <T> List<T> fetchList(String url, Class<T> type) {
		Objects.requireNonNull(type, "A type must provided");
		Log.info("fetch {} object GET /{}", type.getSimpleName(), url);
		try {
			List<T> result =
				createGetRequest(url)
				.execute()
				.handleResponse(createResponseHandler(new TypeReference<List<T>>() {}));
			Log.info("Received {} entries of {}", result.size(), type.getSimpleName());
			return result;
		} catch (IOException e) {
			Log.error(format("Failed to fetch list of {0} from {1}", type.getSimpleName(), url), e);
		}
		Log.info("Received no entries of {}", type.getSimpleName());
		return null;
	}


	/******************************************************************************
	 * Private API
	 ******************************************************************************/

	private Request createGetRequest(String url) {
		return Request
			.Get(Objects.requireNonNull(url, "A URI must provided"))
			.addHeader("Accept", "application/vnd.github.v3+json")
			.addHeader("User-Agent", "RestSpawn");
	}

	private <T> ResponseHandler<T> createResponseHandler(final TypeReference<T> type) {
		return httpResponse -> {

			if (Log.isDebugEnabled()) {
				BasicLineFormatter formatter = BasicLineFormatter.INSTANCE;
				String newLine = System.lineSeparator();
				StringBuilder str = new StringBuilder();
				str.append(httpResponse.getStatusLine()).append(newLine);
				for (Header header : httpResponse.getAllHeaders()) {
					str.append(formatter.formatHeader(null, header)).append(newLine);
				}

				Log.debug("Received http response: {}{}", newLine, str.toString().trim());
			}

            StatusLine statusLine = httpResponse.getStatusLine();
            HttpEntity entity = httpResponse.getEntity();

			if (entity == null) {
				throw new ApiException("Response contains no content", httpResponse);
			}

			ContentType contentType = ContentType.getOrDefault(entity);
			String bodyMessage = EntityUtils.toString(entity, contentType.getCharset());

			if (Log.isDebugEnabled()) {
				Log.debug("Response body: {}", bodyMessage);
			}

			if (statusLine.getStatusCode() > 300) {
				throw new ApiException("Received " + statusLine, httpResponse);
			}

			if (! contentType.getMimeType().equals(ContentType.APPLICATION_JSON.getMimeType())) {
				throw new ApiException("Received invalid content type: " + contentType, httpResponse);
			}

            return objectMapper.readValue(bodyMessage, type);

        };
	}

	private DateFormat buildDefaultFormat() {
		// rfc3339 date format - https://www.ietf.org/rfc/rfc3339.txt
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		this.dateFormat = dateFormat;
		return dateFormat;
	}
}
