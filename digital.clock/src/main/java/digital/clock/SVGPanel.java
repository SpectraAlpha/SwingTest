package digital.clock;
//BAtik
import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.svg.SVGDocumentLoaderAdapter;
import org.apache.batik.swing.svg.SVGDocumentLoaderEvent;
import org.apache.batik.swing.svg.SVGLoadEventDispatcherAdapter;
import org.apache.batik.swing.svg.SVGLoadEventDispatcherEvent;
import org.w3c.dom.svg.SVGDocument;

import javax.swing.*;
import java.awt.*;

import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;


public class SVGPanel extends JPanel {
    private JSVGCanvas svgCanvas;

    public SVGPanel(String svgFilePath) {
        initialize(svgFilePath);
    }

    private void initialize(String svgFilePath) {
        setLayout(new BorderLayout());

        svgCanvas = new JSVGCanvas();
        svgCanvas.setDocumentState(JSVGCanvas.ALWAYS_DYNAMIC);

        // Load and display the SVG document
        try {
            svgCanvas.setURI(new File(svgFilePath).toURI().toURL().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        svgCanvas.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter() {
            @Override
            public void documentLoadingCompleted(SVGDocumentLoaderEvent e) {
                SVGDocument svgDocument = svgCanvas.getSVGDocument();
                if (svgDocument != null) {
                    // Ensure the SVG image scales to fit the panel
                    svgCanvas.setDocument(svgDocument);
                    svgCanvas.setEnablePanInteractor(true);
                    svgCanvas.setEnableZoomInteractor(true);
                }
            }
        });

        svgCanvas.addSVGLoadEventDispatcherListener(new SVGLoadEventDispatcherAdapter() {
            public void svgLoadEventDispatcherDispatchStarted(SVGLoadEventDispatcherEvent e) {
                // Center the SVG content when it is loaded
                svgCanvas.setRenderingTransform(new AffineTransform());
            }
        });

        add(svgCanvas, BorderLayout.CENTER);
    }

    public void updateSVG(String svgFilePath) {
        try {
			svgCanvas.setURI(new File(svgFilePath).toURI().toURL().toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
