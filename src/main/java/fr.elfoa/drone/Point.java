package fr.elfoa.drone;

/**
 * @author Pierre Colomb
 */
public class Point {

    private Double latitude;

    private Double longitude;

    private Double altitude;

    public Point()
    {
        this.latitude = 0d;
        this.longitude = 0d;
        this.altitude = 0d;
    }

    public Point(Double latitude, Double longitude, Double altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public Double getAltitude() {
        return altitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double distanceTo(Point point)
    {
        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(point.latitude - latitude);

        double lonDistance = Math.toRadians(point.longitude - longitude);

        double a = Math.sin(latDistance / 2) *
                   Math.sin(latDistance / 2) +
                   Math.cos(Math.toRadians(latitude)) *
                   Math.cos(Math.toRadians(point.latitude)) *
                   Math.sin(lonDistance / 2) *
                   Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = R * c * 1000; // convert to meters

        double height = altitude - point.altitude;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        final Point point = (Point) obj;
        if(this.latitude.equals(point.getLatitude())
                && this.longitude.equals(point.getLongitude())
                && this.altitude.equals(point.getAltitude())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.altitude.hashCode() + this.longitude.hashCode() + this.latitude.hashCode();
        return hash;
    }
}
