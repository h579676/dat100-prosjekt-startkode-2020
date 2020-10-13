package no.hvl.dat100ptc.oppgave3;
import com.sun.source.doctree.SinceTree;
import static java.lang.Math.*;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
//import sun.security.util.Length;


public class GPSUtils {
	public static double findMax(double[] da) {
		double max; 
		max = da[0];
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		return max;
	}
	//a
	public static double findMin(double[] da) {
		double min;

		min = da[0];
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		return min;
	}
	//b
	public static double[] getLatitudes(GPSPoint[] gpspoints) {
		double tab[] = new double[gpspoints.length];
		for (int i=0; i< gpspoints.length; i++) {
			tab[i]=gpspoints[i].getLatitude();
			}
		return tab;
		}
//c
	public static double[] getLongitudes(GPSPoint[] gpspoints) {
		double tabbel[] = new double[gpspoints.length];
		for (int i=0; i<gpspoints.length; i++) {
			tabbel[i]=gpspoints[i].getLongitude();
			}
		return tabbel;

		
	}

	//d
	private static int R = 6371000; // jordens radius
	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		double d;
		double latitude1,longitude1, latitude2, longitude2;
		latitude1 = gpspoint1.getLatitude();
		latitude2= gpspoint2.getLatitude();
		longitude1= gpspoint1.getLongitude();
		longitude2= gpspoint2.getLongitude();

		
		double fi1 = toRadians(latitude1);
		double fi2 =toRadians(latitude2);
		double deltafi =toRadians(latitude2-latitude1);
		double deltay = toRadians(longitude2-longitude1);

		

		
		double a = pow(sin(deltafi/2),2)+cos(fi1)*cos(fi2)*pow(sin(deltay/2),2);
		double c = 2* atan2(sqrt(a), sqrt(1-a));
		 d = R * c;
		return d;

		
	}

	//e
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		int secs;
		double speed;
		secs = gpspoint2.getTime()-gpspoint1.getTime();
		speed = (distance(gpspoint1, gpspoint2)/secs)*3.6;
		return speed;
	}

	
	//f
	public static String formatTime(int secs) {
		String timestr;
		String TIMESEP = ":";
		int hours = secs / 3600;
		int rest = secs % 3600;
		int minutes = rest / 60;
		rest = rest % 60;
		int seconds = rest;
		timestr = "  " + String.format("%02d", hours) + TIMESEP + String.format("%02d", minutes) + TIMESEP
				+ String.format("%02d", seconds);
		return timestr;
	}




//g





	
	private static int TEXTWIDTH = 10;


	
	public static String formatDouble(double d) {

		
	double roundOff = Math.round(d * 100.0) / 100.0;
		String str;

		

		
	str = String.format("%" + TEXTWIDTH + "s", Math.round(d*100)/100.00);
	return str;

	
	}
}