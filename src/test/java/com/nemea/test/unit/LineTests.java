package com.nemea.test.unit;

import com.nemea.Line;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for the <code>getDistance</code>, <code>getSlope</code> and <code>parallelTo</code> methods in the <code>Line</code> class.
 */
public class LineTests {

    private Line horizontalLine1 = new Line(0, 0, 100,0);
    private Line horizontalLine2 = new Line(200, 100, 500, 100);
    private Line verticalLine1 = new Line(0, 0, 0, 100);
    private Line verticalLine2 = new Line(200, 100, 200, 500);
    private Line diagonalLine45Degree1 = new Line(0, 0, 100, 100);
    private Line diagonalLine45Degree2 = new Line(200, 200, 500, 500);
    private Line diagonalLineGentle = new Line(200, 100, 500, 200);
    private Line diagonalLineSteep1 = new Line(100, 100, 200, 900);
    private Line diagonalLineSteep2 = new Line(100, 100, 200, 899.99);

    /**
     * Asserts the correct distance of a horizontal line.
     */
    @Test
    public void horizontalLineDistance() {
        assertEquals("Wrong distance", 100.0, horizontalLine1.getDistance(), 0.0);
    }

    /**
     * Asserts the correct slope of a horizontal line.
     */
    @Test
    public void horizontalLineSlope() {
        assertEquals("Wrong slope", 0.0, horizontalLine1.getSlope(), 0.0);
    }

    /**
     * Asserts that two horizontal lines are parallel.
     */
    @Test
    public void horizontalLinesParallel() {
        assertTrue("Lines are not parallel, but should be", horizontalLine1.parallelTo(horizontalLine2));
    }

    /**
     * Asserts the correct distance of a vertical line.
     */
    @Test
    public void verticalLineDistance() {
        assertEquals("Wrong distance", 100.0, verticalLine1.getDistance(), 0.0);
    }

    /**
     * Expects an <code>ArithmeticException</code> when getting the slop of a vertical line.
     * This happens because the slope of a vertical line on a cartesian axes is undefined.
     */
    @Test(expected = ArithmeticException.class)
    public void verticalLineSlope() {
        verticalLine1.getSlope();
    }

    /**
     * Expects an <code>ArithmeticException</code> when checking whether two vertical lines are parallel.
     * This happens because the slope, which is used to determine whether two lines are parallel, of a vertical line on a cartesian axes is undefined.
     */
    @Test(expected = ArithmeticException.class)
    public void verticalLinesParallel() {
        verticalLine1.parallelTo(verticalLine2);
    }

    /**
     * Expects an <code>ArithmeticException</code> when checking whether a horizontal line and a vertical line are parallel.
     * This happens because the slope, which is used to determine whether two lines are parallel, of a vertical line on a cartesian axes is undefined.
     */
    @Test(expected = ArithmeticException.class)
    public void horizontalAndVerticalLinesNotParallel() {
        horizontalLine1.parallelTo(verticalLine2);
    }

    /**
     * Asserts the correct distance of a diagonal line.
     */
    @Test
    public void diagonalLineDistance() {
        assertEquals("Wrong distance", 141.4213562373095, diagonalLine45Degree1.getDistance(), 0.0);
    }

    /**
     * Asserts the correct slope of a diagonal line.
     */
    @Test
    public void diagonalLineSlope() {
        assertEquals("Wrong slope", 1.0, diagonalLine45Degree1.getSlope(), 0.0);
    }

    /**
     * Asserts that two diagonal lines are parallel.
     */
    @Test
    public void diagonalLinesParallel() {
        assertTrue("Lines are not parallel, but should be", diagonalLine45Degree1.parallelTo(diagonalLine45Degree2));
    }

    /**
     * Asserts the correct slope of a diagonal line.
     */
    @Test
    public void diagonalLineGentleSlope() {
        assertEquals("Wrong slope", 0.3333333333333333, diagonalLineGentle.getSlope(), 0.0);
    }

    /**
     * Asserts the correct slope of a diagonal line.
     */
    @Test
    public void diagonalLineSteepSlope() {
        assertEquals("Wrong slope", 8.0, diagonalLineSteep1.getSlope(), 0.0);
    }

    /**
     * Asserts that two diagonal lines at different slopes are not parallel.
     */
    @Test
    public void diagonalLinesNotParallel() {
        assertFalse("Lines are parallel, but should not be", diagonalLineGentle.parallelTo(diagonalLineSteep1));
    }

    /**
     * Asserts that two diagonal lines that have almost identical slopes are deemed as parallel.
     */
    @Test
    public void diagonalLinesAlmostParallel() {
        assertTrue("Lines are not parallel, but should be", diagonalLineSteep1.parallelTo(diagonalLineSteep2));
    }
}