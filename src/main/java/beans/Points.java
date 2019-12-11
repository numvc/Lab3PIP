package beans;

import controller.Handler;
import data.Point;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;


@ViewScoped
@ManagedBean(name = "Points")
public class Points implements Serializable {

    private Double x;
    private Double y;
    private Double r;
    private boolean r1;
    private boolean r2;
    private boolean r3;
    private boolean r4;
    private boolean r5;
    private boolean check; //1 - попал, 0 - промах

    public Points() {

    }

    public Points(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public void check() {
        if ((x >= 0) && (y >= 0) && (x * x + y * y <= r * r / 4)) { //the first part
            check = true;
        } else if ((x <= 0) && (y <= 0) && (-y <= r / 2) && (-x <= r)) { //the third part
            check = true;
        } else if ((x >= 0) && (y <= 0) && (y >= 2 * x - r)) { //the fourth
            check = true;
        } else {
            check = false;
        }

        System.out.println(x+" "+y+" "+r);
        Point point = new Point(x, y, r, check);
        Handler.addInDb(point);

    }

    public boolean getR5() {
        return r5;
    }

    public void setR5(boolean r5) {
        setR(3.0);
        this.r5 = r5;
    }

    public boolean getR4() {
        return r4;
    }

    public void setR4(boolean r4) {
        setR(2.5);
        this.r4 = r4;
    }

    public boolean getR3() {
        return r3;
    }

    public void setR3(boolean r3) {
        setR(2.0);
        this.r3 = r3;
    }

    public boolean getR2() {
        return r2;
    }

    public void setR2(boolean r2) {
        setR(1.5);
        this.r2 = r2;
    }

    public boolean getR1() {
        return r1;
    }

    public void setR1(boolean r1) {
        setR(1.0);
        this.r1 = r1;
    }

    public void activeR1() {
        r2 = false;
        r3 = false;
        r4 = false;
        r5 = false;
    }

    public void activeR2() {
        r1 = false;
        r3 = false;
        r4 = false;
        r5 = false;
    }

    public void activeR3() {
        r1 = false;
        r2 = false;
        r4 = false;
        r5 = false;
    }

    public void activeR4() {
        r1 = false;
        r2 = false;
        r3 = false;
        r5 = false;
    }

    public void activeR5() {
        r1 = false;
        r2 = false;
        r3 = false;
        r4 = false;
    }

    public String getValidateR() {
        if (r1 == false && r2 == false && r3 == false && r4 == false && r5 == false) {
            return "Выберите радиус!";
        }
        return "";
    }

    public boolean getReady() {
        if (this.x != null && this.y != null && this.r != null) {
            System.out.println(r);
        }
        return this.x != null && this.y != null && this.r != null && (r1 == true || r2 == true || r3 == true || r4 == true || r5 == true);
    }

}