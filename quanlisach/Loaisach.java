/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisach;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author HUNG
 */
public class Loaisach {

    private String maloai;
    private String tenloai;
    public Loaisach() {
    }

    public Loaisach(String maloai, String tenloai) {
        this.maloai = maloai;
        this.tenloai = tenloai;
    }
    public Loaisach(Loaisach ls)
    {
        maloai=ls.maloai;
        tenloai=ls.tenloai;
    }
    public void Nhap()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Moi ban nhap ma loai: ");
        maloai=sc.nextLine();
        System.out.println("Moi ban nhap ten loai: ");
        tenloai=sc.nextLine();
    }
    public void Xuat()
    {
        System.out.printf("\n|%-50s|%-50s|",maloai,tenloai);
    }
   {
       
   }

    public String getMaloai() {
        return maloai;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }
    public void ghifile(String filename) throws FileNotFoundException, IOException
    {
        try{
        DataOutputStream outstream=new DataOutputStream(new FileOutputStream(filename,true));
        outstream.writeUTF(this.maloai);
        outstream.writeUTF(this.tenloai);
        outstream.close();
    }catch(IOException e)
    {
        System.out.println("IOEROR: "+e.getMessage()+"\n");
    }
        
    }
    
    
}
