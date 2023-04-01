
public class HtmlAnalyzer {

	public static void main(String[] args) {
		
		HtmlManager manager = new HtmlManager("http://hiring.axreng.com/internship/example1.html");
		manager.loadPage();
		manager.findDeepestText();
		String output = manager.getDeepestText();
		
		System.out.println(output);
	}
}