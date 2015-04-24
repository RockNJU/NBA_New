package UI.team;

import java.io.IOException;

import javax.swing.JPanel;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.batik.apps.rasterizer.SVGConverterException;

public class BasicT extends JPanel {

	/**
	 * Create the panel.
	 * @throws SVGConverterException 
	 * @throws IOException 
	 * @throws TransformerException 
	 * @throws TransformerFactoryConfigurationError 
	 */
	public BasicT(String name,String season) throws TransformerFactoryConfigurationError, TransformerException, IOException, SVGConverterException {
		setSize(760,500);
		setLayout(null);
		setOpaque(false);
		
		BasicInfo_1 panel = new BasicInfo_1(name,season);
		panel.setLocation(80, 10);
		panel.setSize(582,474);
		add(panel);
	}

}
