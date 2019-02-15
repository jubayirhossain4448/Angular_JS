/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author l2pc209e
 *
 *
 */
@ManagedBean
@SessionScoped
public class Product {

    Connection con;
    PreparedStatement pstm;
    ResultSet rs;

    private int pid;
    private String name;
    private double price;
    private double stock;
    private double total;
    private int selectedPid;

    private List<Product> proList = new ArrayList<Product>();

    public Product() {
    }

    public Product(int pid, String name, double price, double stock, double total) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.total = total;
        
    }

   

    /**
     * @return the pid
     */
    public int getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(int pid) {
        this.pid = pid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the stock
     */
    public double getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(double stock) {
        this.stock = stock;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the selectedPid
     */
    public int getSelectedPid() {
        return selectedPid;
    }

    /**
     * @param selectedPid the selectedPid to set
     */
    public void setSelectedPid(int selectedPid) {
        this.selectedPid = selectedPid;
    }

    /**
     * @return the proList
     */
    public List<Product> getProList() {
        return proList;
    }

    /**
     * @param proList the proList to set
     */
    public void setProList(List<Product> proList) {
        this.proList = proList;
    }

    public void doSave() {
        ConnectP cp = new ConnectP();
        try {
            con = cp.doConnect();
            pstm = con.prepareStatement("insert into product values(?,?,?,?,?)");
            pstm.setInt(1, pid);
            pstm.setString(2, name);
            pstm.setDouble(3, price);
            pstm.setDouble(4, stock);
            pstm.setDouble(5, total);
            int i = pstm.executeUpdate();
            doShow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doUpdate() {
        ConnectP cp = new ConnectP();
        try {
            con = cp.doConnect();
            pstm = con.prepareStatement("update product set name=?,price=?,stock=?,total=? where pid=?");

            pstm.setString(1, name);
            pstm.setDouble(2, price);
            pstm.setDouble(3, stock);
            pstm.setDouble(4, total);
            pstm.setInt(5, selectedPid);
            int i = pstm.executeUpdate();
            doShow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doDelete() {
        ConnectP cp = new ConnectP();
        try {
            con = cp.doConnect();
            pstm = con.prepareStatement("delete from product where pid=?");
            pstm.setInt(1, selectedPid);
            int i = pstm.executeUpdate();
            doShow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> doShow() {
        ConnectP cp = new ConnectP();
        try {
            con = cp.doConnect();
            pstm = con.prepareStatement("select * from product");
            rs = pstm.executeQuery();
            proList.clear();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5));
                proList.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proList;
    }

    public List<Integer> getDoLoad() {
        ConnectP cp = new ConnectP();
        List<Integer> proLoad = new ArrayList<Integer>();
        try {
            con = cp.doConnect();
            pstm = con.prepareStatement("select * from product");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5));
                proLoad.add(p.getPid());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proLoad;
    }

    public void ajaxList() {
        ConnectP cp = new ConnectP();
        try {
            con = cp.doConnect();
            pstm = con.prepareStatement("select * from product where pid=?");
            pstm.setInt(1, selectedPid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                setPid(rs.getInt(1));
                setName(rs.getString(2));
                setPrice(rs.getDouble(3));
                setStock(rs.getDouble(4));
                setTotal(rs.getDouble(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
