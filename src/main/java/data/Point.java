package data;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "POINTS")
public class Point implements Serializable {
    @Id
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

    @Column(name = "USER_NAME")
    private String user;

    public Point(){}

    public Point(double x, double y, double r, int check, String user){
        this.x = x;
        this.y = y;
        this.r = r;
        this.check = check;
        this.user = user;
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

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
