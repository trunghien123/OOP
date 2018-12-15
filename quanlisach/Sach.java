/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisach;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
//import org.omg.CORBA.DataInputStream;

/**
 *
 * @author HUNG
 */
abstract class Sach {
    private String masach;
 private String tensach;
 private String matacgia;
 private String manhasanxuat;
 private String maloai;
 private String magiamgia;
 private int dongia;
 private int soluong;
 
 	public Sach() {}
 	public Sach(String masach, String tensach, String matacgia, String manhasanxuat, String maloai,String magiamgia, int dongia, int soluong)
 	{
 		this.masach=masach;
 		this.tensach=tensach;
 		this.matacgia=matacgia;
 		this.manhasanxuat=manhasanxuat;
 		this.maloai=maloai;
                this.magiamgia = magiamgia;
 		this.dongia=dongia;
 		this.soluong=soluong;
 	}
 	public Sach(Sach s)
 	{
 		masach=s.masach;
 		tensach=s.tensach;
 		matacgia=s.matacgia;
 		manhasanxuat=s.manhasanxuat;
 		maloai=s.maloai;
                magiamgia = s.magiamgia;
 		dongia=s.dongia;
 		soluong=s.soluong;
 	}
 	public void Nhap()
 	{
 		Scanner nhap=new Scanner(System.in);
 		System.out.println("Nhap vao ma sach: ");
 		 	masach=nhap.nextLine();
 		System.out.println("Nhap vao ten sach: ");
 			tensach=nhap.nextLine();
 		System.out.println("Nhap vao ma tac gia: ");
 			matacgia=nhap.nextLine();
 		System.out.println("Nhap vao ma nha san xuat: ");
 		 	manhasanxuat=nhap.nextLine();
 		System.out.println("Nhap vao ma loai sach: ");
 		 	maloai=nhap.nextLine();
        System.out.println("Nhap vao ma giam gia: ");
 		 	magiamgia=nhap.nextLine();
 		System.out.println("Nhap vao don gia: ");
 			dongia=nhap.nextInt();
                        nhap.nextLine();
 		System.out.println("Nhap vao so luong: ");
 			soluong=nhap.nextInt();
 	}
 	public void Xuat()
 	{
 		System.out.printf("\n|%-10s|%-30s|%-10s|%-15s|%-15s|%-10s|%-10s|%-10s|",masach,tensach,matacgia,manhasanxuat,maloai,magiamgia,soluong,dongia);
 		
 	}
 	public String getMasach()
 	{
 		return masach;
 	}
 	public String getTensach()
 	{
 		return tensach;
 	}
 	public String getMatacgia()
 	{
 		return matacgia;
 	}
 	public String getManhasanxuat()
 	{
 		return manhasanxuat;
 	}
 	public String getMaloai()
 	{
 		return maloai;
 	}
 	public int getDongia()
 	{
 		return dongia;
 	}
 	public int getSoluong()
 	{
 		return soluong;
 	}
 	public void setMasach(String masach)
 	{
 		this.masach=masach;
 	}
 	public void setTensach(String tensach)
 	{
 		this.tensach=tensach;
 	}
 	public void setMatacgia(String matacgia)
 	{
 		this.matacgia=matacgia;
 	}
 	public void setManhasanxuat(String manhasanxuat)
 	{
 		this.manhasanxuat=manhasanxuat;
 	}
 	public void setMaloai(String maloai)
 	{
 		this.maloai=maloai;
 	}
 	public void setDongia(int dongia)
 	{
 		this.dongia=dongia;
 	}
 	public void setSoluong(int soluong)
 	{
 		this.soluong=soluong;
 	}

    public String getMagiamgia() {
        return magiamgia;
    }

    public void setMagiamgia(String magiamgia) {
        this.magiamgia = magiamgia;
    }
        
   
}
