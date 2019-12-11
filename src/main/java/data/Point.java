package data;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "POINTS")
public class Point implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "X")
    private Double x;
    @Column(name = "Y")
    private Double y;
    @Column(name = "R")
    private Double r;
    private boolean check; //1 - попал, 0 - промах

    public Point(){}

    public Point(double x, double y, double r, boolean check){
        this.x = x;
        this.y = y;
        this.r = r;
        this.check = check;
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

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
