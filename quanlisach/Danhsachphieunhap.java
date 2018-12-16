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
    public void Xuat(){
    	System.out.printf("\n%-100s","________________________________________________________________________________________");
    	System.out.printf("\n|%-13s|%-10s|%-13s|%-10s|%-10s|%-13s|%-11s|","Maphieunhap","Masach","Ngaynhap","Soluong","Dongia","Manhacungcap","Manhanvien");
		System.out.printf("\n|%-100s","---------------------------------------------------------------------------------------");
		for(int i=0;i<n;i++)
		{
			dspn[i].Xuat();
			System.out.printf("\n|%-10s","---------------------------------------------------------------------------------------");
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
    
  //Them nhieu phieu nhap
    public void Themk()
    {
   	 int k;
   	 System.out.println("\nMoi ban nhap vao so luong can them: ");
   	 Scanner in = new Scanner(System.in);
   	 k = in.nextInt();
   	 in.nextLine();
   	 for(int i=0 ; i<k;i++)
   	 {
   		 Them();
   	 }
    }
    public void Suatheoma()
    {
    	String ma;
    	System.out.println("\nNhap vao ma de can sua: ");
    	Scanner in =new Scanner(System.in);
    	ma = in.nextLine();
    	String maphieunhapmoi;
    	String masachmoi;
    	String ngaynhapmoi;
    	int soluongmoi;
    	float dongiamoi;
    	String manhacungcapmoi;
    	String manhanvienmoi;
    	for(int i=0 ; i<n ;i++)
    	{
    		if(dspn[i].getMaphieunhap().equals(ma))
    		{
    			int luachon;
    			while(true)
    			{
    				System.out.println("\n1.Sua ma phieu nhap.");
    				System.out.println("\n2.Sua ma sach.");
    				System.out.println("\n3.Sua ngay nhap.");
    				System.out.println("\n4.Sua so luong.");
    				System.out.println("\n5.Sua don gia.");
    				System.out.println("\n6.Sua ma nha cung cap.");
    				System.out.println("\n7.Sua ma nhan vien.");
    				System.out.println("\n8.Thoat.");
    				System.out.println("\nMoi ban nhap vao lua chon: ");
    				luachon= in.nextInt();
    				in.nextLine();
    				if(luachon<1 || luachon>8)
    				{
    					System.out.println("\nMoi ban nhap dung lua chon. Cam on!!!");
    				}
    				if(luachon==1)
    				{
    					System.out.println("\nMoi ban nhap vao ma phieu nhap moi: ");
    					maphieunhapmoi=in.nextLine();
    					dspn[i].setMaphieunhap(maphieunhapmoi);
    				}
    				if(luachon==2)
    				{
    					System.out.println("\nMoi ban nhap vao ma sach moi: ");
    					masachmoi=in.nextLine();
    					dspn[i].setMasach(masachmoi);
    				}
    				if(luachon==3)
    				{
    					System.out.println("\nMoi ban nhap vao ngay nhap moi: ");
    					ngaynhapmoi=in.nextLine();
    					dspn[i].setNgaynhap(ngaynhapmoi);
    				}
    				if(luachon==4)
    				{
    					System.out.println("\nMoi ban nhap vao so luong moi: ");
    					soluongmoi=in.nextInt();
    					in.nextLine();
    					dspn[i].setSoluong(soluongmoi);
    				}
    				if(luachon==5)
    				{
    					System.out.println("\nMoi ban nhap vao don gia moi: ");
    					dongiamoi=in.nextFloat();
    					in.nextLine();
    					dspn[i].setDongia(dongiamoi);
    				}
    				if(luachon==6)
    				{
    					System.out.println("\nMoi ban nhap vao ma nha cung cap moi: ");
    					manhacungcapmoi=in.nextLine();
    					dspn[i].setManhacungcap(manhacungcapmoi);
    				}
    				if(luachon==7)
    				{
    					System.out.println("\nMoi ban nhap vao ma nhan vien moi: ");
    					manhanvienmoi=in.nextLine();
    					dspn[i].setManhanvien(manhanvienmoi);
    				}
    				if(luachon==8)
    				{
    					System.out.println("\nBan da thoat thanh cong.");
    					break;
    				}	
    			}
    		}
//    		if(dspn[i].getMaphieunhap()!=ma)
//    		{
//    			System.out.println("\nKhong tim thay ma can sua.");
//    		}
    	}
    }
   public void Timkiemtheoma()
   {
	   Scanner in =new Scanner(System.in);
	   String ma;
	   System.out.println("\nNhap ma can tim kiem: ");
	   ma = in.nextLine();
	   	System.out.printf("\n%-100s","________________________________________________________________________________________");
   		System.out.printf("\n|%-13s|%-10s|%-13s|%-10s|%-10s|%-13s|%-11s|","Maphieunhap","Masach","Ngaynhap","Soluong","Dongia","Manhacungcap","Manhanvien");
		System.out.printf("\n|%-100s","---------------------------------------------------------------------------------------");
       for(int i = 0 ; i < n ; i++)
       {
           if(dspn[i].getMaphieunhap().equals(ma))
           {
               dspn[i].Xuat();
               System.out.printf("\n|%-10s","---------------------------------------------------------------------------------------");
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
