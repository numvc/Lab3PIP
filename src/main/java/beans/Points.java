package beans;

import com.google.gson.Gson;
import controller.Handler;
import data.Point;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;


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
    private int check; //1 - попал, 0 - промах
    private Double xCanvas;
    private Double yCanvas;
    private Double rCanvas;

    private String pointsJson;

    private Handler handler = null;

    private List<Point> points;

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
        System.out.println("Меняем радиус на " + r);
        this.r = r;
    }

    public void checkAndAddFromForm() {

        if (handler == null) handler = new Handler();

        if ((x >= 0) && (y >= 0) && (x * x + y * y <= r * r / 4)) { //the first part
            check = 1;
        } else if ((x <= 0) && (y <= 0) && (-y <= r / 2) && (-x <= r)) { //the third part
            check = 1;
        } else if ((x >= 0) && (y <= 0) && (y >= 2 * x - r)) { //the fourth
            check = 1;
        } else {
            check = 0;
        }

        Point point = new Point(x, y, r, check);
        handler.addInDb(point);
    }

    public void checkAndAddFromGraph(){
        System.out.println("ПЫТАЮСЬ ДОБАВИТЬ");
        System.out.println(getxCanvas() + " " + getyCanvas());

        if (handler == null) handler = new Handler();

        if ((getxCanvas() >= 0) && (getyCanvas() >= 0) && (getxCanvas() * getxCanvas() + getyCanvas() * getyCanvas() <= getrCanvas() * getrCanvas() / 4)) { //the first part
            check = 1;
        } else if ((getxCanvas() <= 0) && (getyCanvas() <= 0) && (-getyCanvas() <= getrCanvas() / 2) && (-getxCanvas() <= getrCanvas())) { //the third part
            check = 1;
        } else if ((getxCanvas() >= 0) && (getyCanvas() <= 0) && (getyCanvas() >= 2 * getxCanvas() - getrCanvas())) { //the fourth
            check = 1;
        } else {
            check = 0;
        }

        Point point = new Point(getxCanvas(), getyCanvas(), getrCanvas(), check);
        handler.addInDb(point);



    }


    public boolean getR5() {
        return r5;
    }

    public void setR5(boolean r5) {
        this.r5 = r5;
    }

    public boolean getR4() {
        return r4;
    }

    public void setR4(boolean r4) {
        this.r4 = r4;
    }

    public boolean getR3() {
        return r3;
    }

    public void setR3(boolean r3) {
        this.r3 = r3;
    }

    public boolean getR2() {

        return r2;
    }

    public void setR2(boolean r2) {
        this.r2 = r2;
    }

    public boolean getR1() {
        return r1;
    }

    public void setR1(boolean r1) {
        this.r1 = r1;
    }

    public void changeR1() {
        if(getR1() == true) {
            setR1(false);
            setR(null);
            setrCanvas(null);
        } else {
            setR1(true);
            setR(1.0);
            setrCanvas(1.0);
            r2 = false;
            r3 = false;
            r4 = false;
            r5 = false;
        }
    }

    public void changeR2() {
        if(getR2() == true) {
            setR2(false);
            setR(null);
            setrCanvas(null);
        } else {
            setR2(true);
            setR(1.5);
            setrCanvas(1.5);
            r1 = false;
            r3 = false;
            r4 = false;
            r5 = false;
        }
    }

    public void changeR3() {
        if(getR3() == true) {
            setR3(false);
            setR(null);
            setrCanvas(null);
        } else {
            setR3(true);
            setR(2.0);
            setrCanvas(2.0);
            r1 = false;
            r2 = false;
            r4 = false;
            r5 = false;
        }
    }

    public void changeR4() {
        if(getR4() == true) {
            setR4(false);
            setR(null);
            setrCanvas(null);
        } else {
            setrCanvas(2.5);
            setR(2.5);
            setR4(true);
            r1 = false;
            r2 = false;
            r3 = false;
            r5 = false;
        }
    }

    public void changeR5() {
        if(getR5() == true) {
            setR5(false);
            setR(null);
            setrCanvas(null);
        } else {
            setR5(true);
            setR(3.0);
            setrCanvas(3.0);
            r1 = false;
            r2 = false;
            r3 = false;
            r4 = false;
        }
    }

    public String getValidateR() {
        if (r1 == false && r2 == false && r3 == false && r4 == false && r5 == false) {
            return "Выберите радиус!";
        }
        return "";
    }

    public boolean getReady() {
        return this.x != null && this.y != null && (r1 == true || r2 == true || r3 == true || r4 == true || r5 == true);
    }

    public List<Point> getPoints() {
        if (handler == null) handler = new Handler();
        List<Point> currTableList = handler.getTableContext();
        if(currTableList != points) {
            points = handler.getTableContext();
        }
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public Double getxCanvas() {
        return xCanvas;
    }

    public void setxCanvas(Double xCanvas) {
        this.xCanvas = xCanvas;
    }

    public Double getyCanvas() {
        return yCanvas;
    }

    public void setyCanvas(Double yCanvas) {
        this.yCanvas = yCanvas;
    }

    public Double getrCanvas() {
        return rCanvas;
    }

    public void setrCanvas(Double rCanvas) {
        System.out.println("Радиус на канвасе стал " + rCanvas);
        this.rCanvas = rCanvas;
    }

    public String getPointsJson() {
        pointsJson = new Gson().toJson(getPoints());
        return pointsJson;
    }

    public void setPointsJson(String pointsJson) {
        this.pointsJson = pointsJson;
    }
}