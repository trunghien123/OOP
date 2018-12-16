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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
class Khachhang {
private String makhachhang;
private String hokhachhang;
private  String tenkhachhang;
private String diachi; 
private String dienthoai; 
public Khachhang(){}
public Khachhang(String makhachhang, String hokhachhang, String tenkhachhang, String diachi, String dienthoai)
{
    this.makhachhang = makhachhang;
    this.hokhachhang = hokhachhang; 
    this.tenkhachhang = tenkhachhang; 
    this.diachi = diachi; 
    this.dienthoai = dienthoai; 
} 
public Khachhang (Khachhang kh)
{
    this.makhachhang = kh.makhachhang; 
    this.hokhachhang = kh.hokhachhang; 
    this.tenkhachhang = kh.tenkhachhang; 
    this.diachi = kh.diachi; 
    this.dienthoai = kh.dienthoai;   
}  

    Khachhang(String id, String name, String address, String phone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public void Nhap()
{
    Scanner sc = new Scanner (System.in);
    System.out.println ("Nhap ma khach hang:"); 
    makhachhang = sc.nextLine(); 
    System.out.println ("Nhap ho khach hang:"); 
    hokhachhang = sc.nextLine();
    System.out.println ("Nhap ten khach hang:"); 
    tenkhachhang = sc.nextLine(); 
    System.out.println ("Nhap dia chi:");
    diachi = sc.nextLine(); 
    System.out.println ("Nhap dien thoai:"); 
    dienthoai = sc.nextLine(); 
}
public void Xuat()
	{
		System.out.printf("\n|%-15s|%-15s|%-15s|%-15s|%-15s",makhachhang,hokhachhang,tenkhachhang,diachi,dienthoai);
		
	}
public String getMakhachhang()
{
    return makhachhang;
} 
public String getHokhachhang()
{
    return hokhachhang; 
}
public String getTenkhachhang()
{
    return tenkhachhang; 
}
public String getDiachi()
{
    return diachi; 
}
public String getDienthoai()
{
    return dienthoai;
}
public void setMakhachhang(String makhachhang)
{
    this.makhachhang = makhachhang;
}
public void setHokhachhang(String hokhachhang)
{
    this.hokhachhang = hokhachhang;
}
public void setTenkhachhang(String tenkhachhang)
{
    this.tenkhachhang = tenkhachhang; 
}
public void setDiachi (String diachi)
{
    this.diachi = diachi;
}
public void setDienthoai (String dienthoai)
{
    this.dienthoai = dienthoai;
}

void Ghifile(String filename) 
{
        try{
            DataOutputStream outstream = new DataOutputStream(new FileOutputStream(filename,true));
            outstream.writeUTF(this.makhachhang);
            outstream.writeUTF(this.hokhachhang);
            outstream.writeUTF(this.tenkhachhang);
            outstream.writeUTF(this.diachi);
            outstream.writeUTF(this.dienthoai);
            outstream.close();
            
        }
        catch(IOException e)
        {
            System.out.println("Error "+e.getMessage()+"\n");
        }
    }
    
}
