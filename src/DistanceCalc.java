import java.util.Scanner;

//Java program to calculate distance
public class distanceCalc {
 
    private static final double EARTH_RADIUS = 6371.0; // Radius of the Earth in kilometers
 
    public static double calculateVincentyDistance(double lat1, double lon1, double lat2, double lon2) {
        // Convert latitude and longitude to radians
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Difference in longitudes
        double deltaLon = lon2Rad - lon1Rad;

        // Vincenty formula variables
        double a = EARTH_RADIUS;
        double b = EARTH_RADIUS;
        double f = 1 / 298.257223563; // Earth's flattening
        double p1 = Math.atan((1 - f) * Math.tan(lat1Rad));
        double p2 = Math.atan((1 - f) * Math.tan(lat2Rad));
        double l = deltaLon;

        double sinLambda, cosLambda, sinSigma, cosSigma, sigma, sinAlpha, cosSqAlpha, cos2SigmaM;
        double lambda = l;
        double lambdaPrev = Double.MAX_VALUE;

        //initializing formula
        while (Math.abs(lambda - lambdaPrev) > 1e-12) {
            sinLambda = Math.sin(lambda);
            cosLambda = Math.cos(lambda);
            sinSigma = Math.sqrt(Math.pow((Math.cos(p2) * sinLambda), 2) +
                                 Math.pow((Math.cos(p1) * Math.sin(p2) - Math.sin(p1) * Math.cos(p2) * cosLambda), 2));
            cosSigma = Math.sin(p1) * Math.sin(p2) + Math.cos(p1) * Math.cos(p2) * cosLambda;
            sigma = Math.atan2(sinSigma, cosSigma);
            sinAlpha = Math.cos(p1) * Math.cos(p2) * sinLambda / sinSigma;
            cosSqAlpha = 1 - Math.pow(sinAlpha, 2);
            cos2SigmaM = cosSigma - 2 * Math.sin(p1) * Math.sin(p2) / cosSqAlpha;

            double C = f / 16 * cosSqAlpha * (4 + f * (4 - 3 * cosSqAlpha));
            lambdaPrev = lambda;
            lambda = l + (1 - C) * f * sinAlpha *
                     (sigma + C * sinSigma * (cos2SigmaM + C * cosSigma * (-1 + 2 * Math.pow(cos2SigmaM, 2))));
        }

        //Calculating distance using Vincenty Formula
        double uSq = cosSqAlpha * ((Math.pow(a, 2) - Math.pow(b, 2)) / Math.pow(b, 2));
        double A = 1 + uSq / 16384 * (4096 + uSq * (-768 + uSq * (320 - 175 * uSq)));
        double B = uSq / 1024 * (256 + uSq * (-128 + uSq * (74 - 47 * uSq)));
        double deltaSigma = B * sinSigma * (cos2SigmaM + B / 4 *
                            (cosSigma * (-1 + 2 * Math.pow(cos2SigmaM, 2)) - B / 6 * cos2SigmaM *
                            (-3 + 4 * Math.pow(sinSigma, 2)) * (-3 + 4 * Math.pow(cos2SigmaM, 2))));

        double distance = b * A * (sigma - deltaSigma);
        return distance;
    }
 
    //Driver code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the latitude and longitude of the first point:");
        System.out.print("Latitude 1: ");
        double lat1 = scanner.nextDouble();
        System.out.print("Longitude 1: ");
        double lon1 = scanner.nextDouble();

        System.out.println("Enter the latitude and longitude of the second point:");
        System.out.print("Latitude 2: ");
        double lat2 = scanner.nextDouble();
        System.out.print("Longitude 2: ");
        double lon2 = scanner.nextDouble();

        scanner.close();
        
        double distance = calculateVincentyDistance(lat1, lon1, lat2, lon2);
        System.out.println("The distance between the two points is: " + distance + " kilometers.");
    }
}
