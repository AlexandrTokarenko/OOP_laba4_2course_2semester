package lab4.main;

import static java.lang.Math.*;

public class Main {

    public final static double EPS = 1e-6;

    public double t = 2.2;

    public static void main(String[] args) {

        Main main = new Main();
        main.run();
    }

    private void run() {

        double x1 = 0.2;
        double x2 = 2;
        double h = 0.004;
        printMax(x1,x2,h);
        printMin(x1,x2,h);
    }

    public double f(double x) {

        if((x - 0.9) < EPS) return (log(x)*log(x)*log(x)+x*x)/sqrt(x+t);
        else return cos(x)+t*sin(x)*sin(x);
    }

    public int countSteps(double start, double finish, double step) {

        return (int)Math.round((finish - start)/step) + 1;
    }

    public double[] funArrayX(double start, double finish, double step) {

        int countSteps = countSteps(start,finish,step);
        double[] arrX = new double[countSteps];
        for (int i = 0; i < countSteps; i ++) {
            arrX[i] = start + i * step;
        }
        return arrX;
    }

    public double[] funArrayY(double[] x) {

        double[] result = new double[x.length];
        for (int i = 0; i < x.length; i ++) {
            result[i] = f(x[i]);
        }
        return result;
    }

    public int maxIndex(double[] arr) {

        int ind = 0;
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                ind = i;
            }
        }
        return ind;
    }

    public int minIndex(double[] arr) {

        int ind = 0;
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                ind = i;
            }
        }
        return ind;
    }

    public double sum(double[] arr) {

        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public double average(double[] arr) {

        return sum(arr)/arr.length;
    }

    public void printMax(double x1, double x2, double h) {

        double[] arrayX = funArrayX(x1,x2,h);
        double[] arrayY = funArrayY(arrayX);
        int indMax = maxIndex(arrayY);
        System.out.printf("max = x: %.3f y: %.3f index: %d\n",arrayX[indMax],arrayY[indMax],indMax);
    }

    public void printMin(double x1, double x2, double h) {

        double[] arrayX = funArrayX(x1,x2,h);
        double[] arrayY = funArrayY(arrayX);
        int indMin = minIndex(arrayY);
        System.out.printf("min = x: %.3f y: %.3f index: %d\n",arrayX[indMin],arrayY[indMin],indMin);
    }
}
