/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisach;

import java.util.Scanner;

/**
 *
 * @author HUNG
 */
public class Loaigiamgia {
  private float sophantram;
    public Loaigiamgia(){}
    public Loaigiamgia(float sophantram)
    {
        this.sophantram=sophantram;
    }
    public Loaigiamgia(Loaigiamgia lgg)
    {
        sophantram=lgg.sophantram;
    }
    public void nhap()
    {
        Scanner nhap=new Scanner(System.in);
        System.out.println("Nhap vao so phan tram giam gia: ");
            sophantram=nhap.nextFloat();
    }
    @Override
    public String toString() {
        StringBuilder s= new StringBuilder();
        s.append("So phan tram: ");
        s.append(this.sophantram+"%");
        return s.toString();
    }
    public float getSophantram()
    {
        return sophantram;
    }
    public void setSophantram(float sophantram)
    {
        this.sophantram=sophantram;
    }
}
