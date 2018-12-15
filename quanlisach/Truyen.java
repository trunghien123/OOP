/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisach;

/**
 *
 * @author HUNG
 */

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
//import org.omg.CORBA.DataInputStream;

public class Truyen extends Sach{
 private int luatuoi;
 private String chude;
 	public Truyen() {}
 	public Truyen(String masach, String tensach, String matacgia, String manhasanxuat, String maloai,String magiamgia, int dongia, int soluong, int luatuoi, String chude)
 	{
 		super(masach,tensach,matacgia,manhasanxuat,maloai,magiamgia,dongia,soluong);
 		this.luatuoi=luatuoi;
 		this.chude=chude;
 	}
 	public Truyen(Truyen tr)
 	{
 		super((Sach)tr);
 		luatuoi=tr.luatuoi;
 		chude=tr.chude;
 	}
 @Override	public void Nhap()
 	{
	 	super.Nhap();
	 	Scanner nhap=new Scanner(System.in);
	 	System.out.println("Nhap vao lua tuoi: ");
	 	 	luatuoi=nhap.nextInt();
                        nhap.nextLine();
	 	
	 	System.out.println("Nhap vao chu de: ");
	 	 	chude=nhap.nextLine();
	 	
 	}
 @Override
 public void Xuat()
	{
	 	super.Xuat();
	 	String kethua="Luatuoi : "+luatuoi+" , Chude : "+chude;
	 	System.out.printf("%-30s|",kethua);
	}
 	public int getLuatuoi() 
 	{
 		return luatuoi;
 	}

    public String getChude() {
        return chude;
    }

    public void setChude(String chude) {
        this.chude = chude;
    }
 	
 	public void setLuatuoi(int luatuoi)
 	{
 		this.luatuoi=luatuoi;
 	}
 	
     
}



