
public class HtmlAnalyzer {

	public static void main(String[] args) {
		
	
		HtmlManager manager = new HtmlManager("...");
		manager.loadPage();
		manager.findDeepestText();
		String output = manager.getDeepestText();
		
		System.out.println(output);
	}
}
