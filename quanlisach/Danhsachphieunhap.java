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
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author HUNG
 */
public class Danhsachphieunhap {
    private int n ;
    private Phieunhap[] dspn = new Phieunhap[1];
    public Danhsachphieunhap(){
    }
    public Danhsachphieunhap(Phieunhap[] a,int n){
        this.n = n;
        this.dspn = Arrays.copyOf(a, n);
    }
    public Danhsachphieunhap(Danhsachphieunhap ds){
        this.n = ds.n;
        this.dspn = Arrays.copyOf(ds.dspn,n);
    }
    public void Nhap(){
        Scanner in = new Scanner(System.in);
        System.out.println("nhap vao so luong phieu nhap hang :");
        this.n = in.nextInt();
        dspn = Arrays.copyOf(dspn,n);
        for(int i = 0 ; i < n ; i++)
        {
            dspn[i] = new Phieunhap();
            dspn[i].Nhap();
        }
        
    }
    public void Xuatdanhsachphieunhap(){
    	System.out.printf("\n%-100s","______________________________________________________________________________________________________________________________________________________");
    	System.out.printf("\n|%-13s|%-10s|%-13s|%-10s|%-10s|%-13s|%-11s|","Maphieunhap","Masach","Ngaynhap","Soluong","Dongia","Manhacungcap","Manhanvien");
		System.out.printf("\n|%-100s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
		for(int i=0;i<n;i++)
		{
			dspn[i].Xuat();
			System.out.printf("\n|%-10s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
		}
    }
    public void xoavt(int vitrixoa){
        for(int i = vitrixoa ; i < n -1 ; i++)
        {
            dspn[i] = dspn[i+1];
        }
        dspn = Arrays.copyOf(dspn,n-1);
        n--;
    }
    public void Xoatheoma(String ma){
        for(int i = 0 ; i < n ; i++)
        {
            if(dspn[i].getMaphieunhap().equals(ma))
            {
                xoavt(i);
            }
        }
    }
    public void Them(){
        dspn = Arrays.copyOf(dspn,n+1);
        dspn[n] = new Phieunhap();
        dspn[n].Nhap();
        n++;
    }
    
    public void ThemK(Phieunhap phieu)
    {
        Them();
    }
   public void Timkiemphieunhap(String ma)
   {
       for(int i = 0 ; i < n ; i++)
       {
           if(dspn[i].getMaphieunhap().equals(ma))
           {
               System.out.println(dspn[i].toString());
           }
       }
   }
    public void Ghifile(String filename) throws FileNotFoundException, IOException{
       DataOutputStream outstream = new DataOutputStream(new FileOutputStream(filename));
       for(int i = 0 ; i < n ; i++)
       {
           dspn[i].Ghifile(filename);
       }
       outstream.close();
   }
   public void Docfile(String filename) throws FileNotFoundException, IOException
   {
       
       int i = 0 ; 
       n = 0;
       try{
           DataInputStream instream = new DataInputStream(new FileInputStream(filename));
           try{
               while(true){
                   String idpn = instream.readUTF();
                   String masach = instream.readUTF();
                   String ngaynhap = instream.readUTF();
                   int number = instream.readInt();
                   float dongia = instream.readFloat();
                   float tongtien = instream.readFloat();
                   String idnhacungcap = instream.readUTF();
                   String idnhanvien = instream.readUTF();
                   dspn = Arrays.copyOf(dspn,n+1);
                   dspn[i] = new Phieunhap(idpn,masach,ngaynhap,number,dongia,tongtien,idnhacungcap,idnhanvien);
                   i++;
                   n++;
               }
           }
           catch(EOFException e){
           }
           finally{
               instream.close();
           }
           
       } catch(FileNotFoundException e){
               System.out.println("IOERROR"+filename+"NOT FOUND");
               
        }
       catch(IOException e){
               System.out.println("IOERROR"+e.getMessage()+"\n");
               }
   }
}
