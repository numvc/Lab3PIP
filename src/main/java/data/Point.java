package data;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "POINTS")
public class Point implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "X")
    private Double x;

    @Column(name = "Y")
    private Double y;

    @Column(name = "R")
    private Double r;

    @Column(name = "RESULT")
    private int check; //1 - попал, 0 - промах

    public Point(){}

    public Point(double x, double y, double r, int check){
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

    public int isCheck() {
        return check;
    }

    public void setCheck(int     check) {
        this.check = check;
    }
}
