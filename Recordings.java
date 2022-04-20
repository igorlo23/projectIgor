import java.util.ArrayList;

public class Recordings implements Comparable<Recordings> {
    private String year;
    private int month;
    private double meant;
    private double maxtp;
    private double mintp;
    private double mnmax;
    private double mnmin;
    private double rain;
    private double gmin;
    private double wdsp;
    private int maxgt;
    private double sun;

    public Recordings(String year, int month, double meant, double maxtp, double mintp, double mnmax, double mnmin, double rain, double gmin, double wdsp, int maxgt, double sun) {
        this.year = year;
        this.month = month;
        this.meant = meant;
        this.maxtp = maxtp;
        this.mintp = mintp;
        this.mnmax = mnmax;
        this.mnmin = mnmin;
        this.rain = rain;
        this.gmin = gmin;
        this.wdsp = wdsp;
        this.maxgt = maxgt;
        this.sun = sun;
    }

    @Override
    public String toString() {
        return "Recordings{" +
                "year='" + year +
                ", month=" + month +
                ", meant=" + meant +
                ", maxtp=" + maxtp +
                ", mintp=" + mintp +
                ", mnmax=" + mnmax +
                ", mnmin=" + mnmin +
                ", rain=" + rain +
                ", gmin=" + gmin +
                ", wdsp=" + wdsp +
                ", maxgt=" + maxgt +
                ", sun=" + sun +
                '}';
    }

    public String getYear() {return year;}

    public void setYear(String year) {this.year = year;}

    public int getMonth() {return month;}

    public void setMonth(int month) {this.month = month;}

    public double getMeant() {return meant;}

    public void setMeant(double meant) {this.meant = meant;}

    public double getMaxtp() {return maxtp;}

    public void setMaxtp(double maxtp) {this.maxtp = maxtp;}

    public double getMintp() {return mintp;}

    public void setMintp(double mintp) {this.mintp = mintp;}

    public double getMnmax() {return mnmax;}

    public void setMnmax(double mnmax) {this.mnmax = mnmax;}

    public double getMnmin() {return mnmin;}

    public void setMnmin(double mnmin) {this.mnmin = mnmin;}

    public double getRain() {return rain;}

    public void setRain(double rain) {this.rain = rain;}

    public double getGmin() {return gmin;}

    public void setGmin(double gmin) {this.gmin = gmin;}

    public double getWdsp() {return wdsp;}

    public void setWdsp(double wdsp) {this.wdsp = wdsp;}

    public int getMaxgt() {return maxgt;}

    public void setMaxgt(int maxgt) {this.maxgt = maxgt;}

    public double getSun() {return sun;}

    public void setSun(double sun) {this.sun = sun;}

    @Override
    public int compareTo(Recordings o) {
        if (this.maxtp > mintp)
            return 1;
        else if (this.maxtp < mintp)
            return -1;
        else
            return 0;
    }
}