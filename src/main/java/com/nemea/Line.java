package com.nemea;

public class Line {

    // private member data
    private double x0, y0, x1, y1;

    /**
     * Constructs a new line object.
     *
     * @param x0 the x-coordinate of point 0.
     * @param y0 the y-coordinate of point 0.
     * @param x1 the x-coordinate of point 1.
     * @param y1 the y-coordinate of point 1.
     */
    public Line(double x0, double y0, double x1, double y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    /**
     * Calculates the line's slope.
     *
     * @return the slope degree value.
     */
    public double getSlope() {
        // avoid dividing by zero
        if (x1 == x0) {
            throw new ArithmeticException();
        }
        return (y1 - y0) / (x1 - x0);
    }

    /**
     * Calculates the distance of the line.
     *
     * @return the calculated line distance.
     */
    public double getDistance() {
        return Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
    }

    /**
     * Determines whether this line is parallel to line l.
     *
     * @param l the {@link Line} object being compared.
     * @return true if line l is parallel and false if otherwise.
     */
    public boolean parallelTo(Line l) {
        // if the difference between the slopes is very small, consider them parallel
        if (Math.abs(getSlope() - l.getSlope()) < .0001) {
            return true;
        } else {
            return false;
        }
    }
}
