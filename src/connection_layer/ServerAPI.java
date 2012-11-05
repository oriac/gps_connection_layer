package connection_layer;

/**
 * The ServerAPI class provides an interface to easily
 * get information from the server.
 * @author Albert Cabré Juan
 */
public class ServerAPI {
	
	/**
	 * Performs a search on the server for avaliable clics
	 * @param tags List of tags on which the query will be performed
	 * @param page If the query result is large enough, this will
	 *  specify the result page.
	 * @return An array of the ClicMetaDatas that matched the search
	 * 	criteria
	 */
	public ClicMetaData[] getList(String[] tags, int page){
		throw new UnsupportedOperationException();
	}	
	
}
