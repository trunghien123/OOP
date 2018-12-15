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
public class Nhacungcap {
    private String manhacungcap;
    private String tennhacungcap;
    private String diachi;
    private String dienthoai;
    public Nhacungcap(){
        
    }

    public Nhacungcap(String manhacungcap, String tennhacungcap, String diachi, String dienthoai) {
        this.manhacungcap = manhacungcap;
        this.tennhacungcap = tennhacungcap;
        this.diachi = diachi;
        this.dienthoai = dienthoai;
    }
    public Nhacungcap(Nhacungcap ncc)
    {
        this.manhacungcap = ncc.manhacungcap;
        this.tennhacungcap = ncc.tennhacungcap;
        this.diachi = ncc.diachi;
        this.dienthoai = ncc.dienthoai;
    }

    public String getManhacungcap() {
        return manhacungcap;
    }

    public void setManhacungcap(String manhacungcap) {
        this.manhacungcap = manhacungcap;
    }

    public String getTennhacungcap() {
        return tennhacungcap;
    }

    public void setTennhacungcap(String tennhacungcap) {
        this.tennhacungcap = tennhacungcap;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }
    public void Nhap(){
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap vao ma nha cung cap ");
        this.manhacungcap = in.nextLine();
        System.out.println("Nhap vao ten nha cung cap ");
        this.tennhacungcap = in.nextLine();
        System.out.println("Nhap vao dia chi ");
        this.diachi = in.nextLine();
        System.out.println("Nhap vao so dien thoai");
        this.dienthoai = in.nextLine();
    }
    public void Xuat()
    {
    	System.out.printf("\n|%-15s|%-15s|%-10s|%-10s|",manhacungcap,tennhacungcap,diachi,dienthoai);
    }
    public void Ghifile(String filename)
    {
        try{
            DataOutputStream outstream = new DataOutputStream(new FileOutputStream(filename,true));
            outstream.writeUTF(this.manhacungcap);
            outstream.writeUTF(this.tennhacungcap);
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
