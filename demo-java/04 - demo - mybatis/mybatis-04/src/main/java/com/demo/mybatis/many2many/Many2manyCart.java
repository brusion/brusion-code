package com.demo.mybatis.many2many;

import java.util.ArrayList;
import java.util.List;

/**
 * @author brusion
 * @date 2018/5/21
 */
public class Many2manyCart {
    /**
     * create table mybatis_many2many_cart (
     * many2many_cart_id int(3) auto_increment not null primary key,
     * many2many_cart_code varchar(50) not null,
     * many2many_cart_name varchar(50) not null);
     */
    private int cartId;
    private String carCode;
    private String cartName;
    private List<Many2manyStudent> studentList = new ArrayList<Many2manyStudent>();

    public List<Many2manyStudent> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Many2manyStudent> studentList) {
        this.studentList = studentList;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public String getCartName() {
        return cartName;
    }

    public void setCartName(String cartName) {
        this.cartName = cartName;
    }

    @Override
    public String toString() {
        return "Many2manyCart{" +
                "cartId=" + cartId +
                ", carCode='" + carCode + '\'' +
                ", cartName='" + cartName + '\'' +
                ", studentList='" + studentList + '\'' +
                '}';
    }
}
