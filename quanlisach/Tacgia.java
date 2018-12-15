/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisach;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author HUNG
 */
public class Tacgia {
    private String matacgia;
    private String tentacgia;
    private String ngaysinh;

    public Tacgia() {
    }

    public Tacgia(String matacgia, String tentacgia, String ngaysinh) {
        this.matacgia = matacgia;
        this.tentacgia = tentacgia;
        this.ngaysinh = ngaysinh;
    }
    public Tacgia(Tacgia tg)
    {
        matacgia=tg.matacgia;
        tentacgia=tg.tentacgia;
        ngaysinh=tg.ngaysinh;
    }
    public void Nhap()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Moi ban nhap ma tac gia: ");
        matacgia=sc.nextLine();
        System.out.println("Moi ban nhap ten tac gia: ");
        tentacgia=sc.nextLine();
        System.out.println("Moi ban nhap ngay sinh: ");
        ngaysinh=sc.nextLine();
    }
    public void Xuat()
    {
        System.out.printf("\n|%-30s|%-30s|%-30s|",matacgia,tentacgia,ngaysinh);
    }

    public String getMatacgia() {
        return matacgia;
    }

    public String getTentacgia() {
        return tentacgia;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setMatacgia(String matacgia) {
        this.matacgia = matacgia;
    }

    public void setTentacgia(String tentacgia) {
        this.tentacgia = tentacgia;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
    public void ghifile(String filename) throws FileNotFoundException
    {
        try{
            DataOutputStream outstream=new DataOutputStream(new FileOutputStream(filename,true));
                outstream.writeUTF(matacgia);
                outstream.writeUTF(tentacgia);
                outstream.writeUTF(ngaysinh);
                outstream.close();
        }
        catch(IOException e){
            System.out.println("IOEROR: "+e.getMessage()+"\n");
        }
    }
}
