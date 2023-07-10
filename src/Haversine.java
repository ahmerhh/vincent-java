import java.util.Scanner;

public class Haversine {
 
    private static final double EARTH_RADIUS = 6371; // Radius of the Earth in kilometers
 
    public static double calculateHaversineDistance(double lat1, double lon1, double lat2, double lon2) {
        // Convert latitude and longitude to radians
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Calculate the differences in latitude and longitude
        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;

        // Apply Haversine formula
        double a = Math.pow(Math.sin(deltaLat / 2), 2) +
                   Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                   Math.pow(Math.sin(deltaLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Calculate the distance
        double distance = EARTH_RADIUS * c;
        return distance;
    }
 
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
        
        double distance = calculateHaversineDistance(lat1, lon1, lat2, lon2);
        System.out.println("The distance between the two points is: " + distance + " kilometers.");
    }
}
