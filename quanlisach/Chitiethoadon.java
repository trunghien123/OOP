
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
public class Chitiethoadon {
    private String mahoadon;
    private String masach;
    private int soluong;
    private float dongia;
    private float thanhtien;
    
    public Chitiethoadon(){
    }
    
    public Chitiethoadon(String mahoadon, String masach, int soluong, float dongia, float thanhtien) {
        this.mahoadon = mahoadon;
        this.masach = masach;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }
    public Chitiethoadon(Chitiethoadon cthd){
        this.mahoadon = cthd.mahoadon;
        this.masach = cthd.masach;
        this.soluong = cthd.soluong;
        this.dongia = cthd.dongia;
        this.thanhtien = cthd.thanhtien;
    }

    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
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

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }
    
    public void Nhap(){
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap vao ma hoa don ");
        this.mahoadon = in.nextLine();
        System.out.println("Nhap vao ma sach ");
        this.masach = in.nextLine();
        System.out.println("Nhap vao so luong");
        this.soluong = in.nextInt();
        in.nextLine();
        System.out.println("Nhap vao don gia ");
        this.dongia = in.nextFloat();
        
    }
   public void Xuat()
	{
		System.out.printf("\n|%-10s|%-10s|%-10s|%-10s|",mahoadon,masach,soluong,dongia);
		
	}
    public void Ghifile(String filename)
    {
       try{
       DataOutputStream outstream = new DataOutputStream(new FileOutputStream(filename,true));
       outstream.writeUTF(this.mahoadon);
       outstream.writeUTF(this.masach);
       outstream.writeInt(this.soluong);
       outstream.writeFloat(this.dongia);
       outstream.writeFloat(this.thanhtien);
       outstream.close();
    }
     catch(IOException e){
         System.out.println("IOERROR"+e.getMessage()+"\n");
         
     }
    }
    
}
