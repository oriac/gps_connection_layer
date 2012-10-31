package connection_layer;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

final class Downloader {
	static byte[] downloadFile(URL url) throws IOException {
		InputStream in = new BufferedInputStream(url.openStream());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int n = 0;
		while ((n = in.read(buf)) != -1) {
			out.write(buf, 0, n);
		}
		out.close();
		in.close();
		return out.toByteArray();
	}

}
