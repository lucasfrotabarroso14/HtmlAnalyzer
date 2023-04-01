import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class HtmlManager {
	
	private ArrayList<String> lines;
	private String page;
	private String deepestText;
	
	public HtmlManager(String page) {
		this.page = page;
		lines = new ArrayList<String>();
		deepestText = "";
	}
	
	public void loadPage() {
		try {
			URL url = new URL(page);
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				lines.add(inputLine.trim());
			}
			br.close();
		} catch (MalformedURLException e) {
			System.out.println("malformed HTML");
			System.exit(1);
		} catch (Exception e) {
			System.out.println("URL connection error");
			System.exit(1);
		}
		
		System.out.println(lines);
	}
	
	public void findDeepestText() {
		int maxNivel = 0;
		int nivelAtual = 0;

		for (int i = 0; i < lines.size(); i++) {
			String element = lines.get(i);
			if (element.charAt(0) == '<') {
				if (element.charAt(1) != '/') {
					nivelAtual++;
				} else {
					nivelAtual--;
				}
			} else {
				if (nivelAtual > maxNivel) {
					maxNivel = nivelAtual;
					deepestText = element;
				}
			}
		}
	}
	
	public String getDeepestText() {
		return deepestText;
	}
}
