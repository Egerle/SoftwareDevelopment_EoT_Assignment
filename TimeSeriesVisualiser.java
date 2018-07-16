package eotpackage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collection;


import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.data.store.ContentFeatureCollection;
import org.geotools.data.store.ContentFeatureSource;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.opengis.feature.Feature;
import org.opengis.feature.Property;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;

import com.vividsolutions.jts.geom.Geometry;

import processing.core.PApplet;

public class TimeSeriesVisualiser extends PApplet  { 
	
	// global variables for width and height of the output window
	int width = 1000;
	int height = 500;
	

	
	
	public static void main(String[] args) {
		
		// reference the Java class
        PApplet.main("eotpackage.TimeSeriesVisualiser");
//        WFSConnector.WFSGetter();
        getTwitter.twitterGetter();
    }
	
	
	public void settings() {
		
		// set the width and the height of the output window
		size(width,height);
		
	} // settings

	
	public void setup(float x, float y) { //float x, float y

		// define the colour mode and set the background colour
		colorMode(HSB, 360, 100, 100);
		background(0);
    	
		// define the style for the circle
    	fill(0,0,20);
        stroke(0,0,70);
      
        // define settings for the circle
        ellipseMode(CENTER);
        smooth();
        
//         float x=500;
//         float y=100;
        

	    ellipse(x, y, 15, 15);
        

	        }
	         
	

} 
