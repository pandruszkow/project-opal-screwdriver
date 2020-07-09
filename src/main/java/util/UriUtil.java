package util;

import java.net.URI;
import java.net.URISyntaxException;

public class UriUtil {

	public static URI parseIgnoringException(String uri){
		try {
			return new URI(uri);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
}
