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
public class Nhaxuatban {
    private String manhaxuatban;
    private String tennhaxuatban;
    private String diachi;
    private String dienthoai;

    public Nhaxuatban() {
    }

    public Nhaxuatban(String manhaxuatban, String tennhaxuatban, String diachi, String dienthoai) {
        this.manhaxuatban = manhaxuatban;
        this.tennhaxuatban = tennhaxuatban;
        this.diachi = diachi;
        this.dienthoai = dienthoai;
    }
    public void Nhaxuatban(Nhaxuatban nxb)
    {
        manhaxuatban=nxb.manhaxuatban;
        tennhaxuatban=nxb.tennhaxuatban;
        diachi=nxb.diachi;
        dienthoai=nxb.dienthoai;
    }
    public void Nhap()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Moi ban nhap ma nha xuat ban: ");
        manhaxuatban=sc.nextLine();
        System.out.println("Moi ban nhap ten nha xuat ban: ");
        tennhaxuatban=sc.nextLine();
        System.out.println("Moi ban nhap dia chi: ");
        diachi=sc.nextLine();
        System.out.println("Moi ban nhap so dien thoai: ");
        dienthoai=sc.nextLine();
    }
    public void Xuat()
    {
        System.out.printf("\n|%-25s|%-25s|%-25s|%-25s|",manhaxuatban,tennhaxuatban,diachi,dienthoai);
    }

    public String getManhaxuatban() {
        return manhaxuatban;
    }

    public String getTennhaxuatban() {
        return tennhaxuatban;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setManhaxuatban(String manhaxuatban) {
        this.manhaxuatban = manhaxuatban;
    }

    public void setTennhaxuatban(String tennhaxuatban) {
        this.tennhaxuatban = tennhaxuatban;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }
    public void ghifile(String filename)
    {
        try{
        DataOutputStream outstream=new DataOutputStream(new FileOutputStream(filename,true));
        outstream.writeUTF(manhaxuatban);
        outstream.writeUTF(tennhaxuatban);
        outstream.writeUTF(diachi);
        outstream.writeUTF(dienthoai);
        outstream.close();
        }catch(IOException e)
        {
            System.out.println("IOERROR: "+e.getMessage()+"\n");
        }
    }
}
