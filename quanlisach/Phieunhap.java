/*
  * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisach;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author HUNG
 */
public class Phieunhap {
    private String maphieunhap;
    private String masach;
    private String ngaynhap;
    private int soluong;
    private float dongia;
    private float tongtien;
    private String manhacungcap;
    private String manhanvien;
    
    public Phieunhap(){
    }
    

    public Phieunhap(String maphieunhap, String masach, String ngaynhap, int soluong, float dongia, float tongtien, String manhacungcap, String manhanvien) {
        this.maphieunhap = maphieunhap;
        this.masach = masach;
        this.ngaynhap = ngaynhap;
        this.soluong = soluong;
        this.dongia = dongia;
        this.tongtien = tongtien;
        this.manhacungcap = manhacungcap;
        this.manhanvien = manhanvien;
    }
    
    public Phieunhap(Phieunhap phieu)
    {
        this.maphieunhap = phieu.maphieunhap;
        this.masach = phieu.masach;
        this.ngaynhap = phieu.ngaynhap;
        this.soluong = phieu.soluong;
        this.dongia = phieu.dongia;
        this.tongtien = phieu.tongtien;
        this.manhacungcap = phieu.manhacungcap;
        this.manhanvien = phieu.manhanvien;
        
    }

    public String getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(String maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }

    public String getManhacungcap() {
        return manhacungcap;
    }

    public void setManhacungcap(String manhacungcap) {
        this.manhacungcap = manhacungcap;
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }
    public void Nhap(){
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap vao ma phieu nhap");
        this.maphieunhap = in.nextLine();
        System.out.println("Nhap vao ma sach");
        this.masach = in.nextLine();
        System.out.println("Nhap vao ngay nhap hang");
        this.ngaynhap = in.nextLine();
        System.out.println("Nhap vao so luong nhap");
        this.soluong = in.nextInt();
        in.nextLine();
        System.out.println("Nhap vao don gia ");
        this.dongia = in.nextFloat();
        in.nextLine();
        System.out.println("Nhap vao ma nha cung cap");
        this.manhacungcap = in.nextLine();
        System.out.println("Nhap vao ma nhan vien ");
        this.manhanvien = in.nextLine();
    }
    public void Xuat()
    {
    	System.out.printf("\n|%-13s|%-10s|%-13s|%-10s|%-10s|%-13s|%-11s|",maphieunhap,masach,ngaynhap,soluong,dongia,manhacungcap,manhanvien);
    }
     public void Ghifile(String filename)
   {
       try{
           DataOutputStream outstream = new DataOutputStream(new FileOutputStream(filename,true));
           outstream.writeUTF(this.maphieunhap);
           outstream.writeUTF(this.masach);
           outstream.writeUTF(this.ngaynhap);
           outstream.writeInt(this.soluong);
           outstream.writeFloat(this.dongia);
           outstream.writeFloat(this.tongtien);
           outstream.writeUTF(this.manhacungcap);
           outstream.writeUTF(this.manhanvien);
           outstream.close();
           
           
       }
       catch(IOException e){
           System.out.println("IOERROR"+e.getMessage()+"\n");
           
       }
    }
}
