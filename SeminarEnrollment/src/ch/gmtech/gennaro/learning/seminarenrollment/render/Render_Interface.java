package ch.gmtech.gennaro.learning.seminarenrollment.render;

public interface Render_Interface {

		abstract String renderHeader();
		abstract String renderBody();
		abstract String renderFooter();
		abstract void print(String path);
	
}
