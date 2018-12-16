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
public class Danhsachchitiethoadon implements Danhsach{
    private int n;
    private Chitiethoadon[] dscthd = new Chitiethoadon[1];

    public Danhsachchitiethoadon(Chitiethoadon[] dscthd,int n) {
        this.n = n;
        this.dscthd = Arrays.copyOf(dscthd, n);
        
    }
    public Danhsachchitiethoadon(Danhsachchitiethoadon ds)
    {
        this.n = ds.n;
        this.dscthd = Arrays.copyOf(ds.dscthd, n);
    }
    public void Nhap(){
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap vao so luong chi tiet hoa don :");
        this.n = in.nextInt();
        dscthd = Arrays.copyOf(dscthd,n);
        for(int i = 0 ; i < n ; i++)
        {
            dscthd[i] = new Chitiethoadon();
            dscthd[i].Nhap();
        }
        
    }
    public void Xuat()
    {
    	System.out.printf("\n%-100s","______________________________________________________________________________________________________________________________________________________");
    	System.out.printf("\n|%-10s|%-10s|%-10s|%-10s|","mahoadon","masach","soluong","dongia");
		System.out.printf("\n|%-100s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
		for(int i=0;i<n;i++)
		{
			dscthd[i].Xuat();
			System.out.printf("\n|%-10s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
		}
    }
    public void Xoavt(int vitrixoa){
        for(int i = vitrixoa ; i < n -1 ; i++)
        {
            dscthd[i] = dscthd[i+1];
        }
        dscthd = Arrays.copyOf(dscthd,n-1);
        n--;
    }
    public void Xoatheoma(String ma){
        for(int i = 0 ; i < n ; i++)
        {
            if(dscthd[i].getMahoadon().equals(ma))
            {
                Xoavt(i);
            }
        }
    }
    public void Them(){
        dscthd = Arrays.copyOf(dscthd,n+1);
        dscthd[n] = new Chitiethoadon();
        dscthd[n].Nhap();
        n++;
    }
  //Them nhieu chi tiet hoa don
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
   public void Timkiemtheoma()
   {
	   String ma;
	   System.out.println("\nNhap vao ma can tim kiem: ");
	   Scanner in=new Scanner(System.in);
	   ma=in.nextLine();
	   	System.out.printf("\n%-100s","______________________________________________________________________________________________________________________________________________________");
   		System.out.printf("\n|%-10s|%-10s|%-10s|%-10s|","mahoadon","masach","soluong","dongia");
		System.out.printf("\n|%-100s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
       for(int i = 0 ; i < n ; i++)
       {
           if(dscthd[i].getMahoadon().equals(ma))
           {
               dscthd[i].Xuat();
               System.out.printf("\n|%-10s","-----------------------------------------------------------------------------------------------------------------------------------------------------"); 
           }
       }
   }
     public void Suatheoma(){
    	 String ma;
    	 System.out.println("\nNhap vao ma can sua: ");
    	 Scanner in = new Scanner(System.in);
    	 ma=in.nextLine();
    	 String mahdmoi;
    	 String masachmoi;
    	 int soluongmoi;
    	 int dongiamoi;
    	 for(int i=0;i<n;i++)
    	 {
    		 if(dscthd[i].getMahoadon().equals(ma))
    		 {
    			 int luachon;
    			 while(true)
    			 {
    				 System.out.println("\n1.Sua ma hoa don.");
    				 System.out.println("\n2.Sua ma sach.");
    				 System.out.println("\n3.Sua so luong.");
    				 System.out.println("\n4.Sua don gia.");
    				 System.out.println("\n5.Thoat.");
    				 System.out.println("\nMoi nhap vao lua chon: ");
    				 luachon=in.nextInt();
    				 in.nextLine();
    				 if(luachon<1 || luachon>5)
    				 {
    					 System.out.println("\nBan da nhap sai lua chon!!!");
    				 }
    				 if(luachon==1)
    				 {
    					 System.out.println("\nMoi ban nhap vao ma hoa don moi: ");
    					 mahdmoi=in.nextLine();
    					 dscthd[i].setMahoadon(mahdmoi);
    				 }
    				 if(luachon==2)
    				 {
    					 System.out.println("\nMoi ban nhap vao ma sach moi: ");
    					 masachmoi=in.nextLine();
    					 dscthd[i].setMasach(masachmoi);
    				 }
    				 if(luachon==3)
    				 {
    					 System.out.println("\nMoi ban nhap vao so luong moi: ");
    					 soluongmoi=in.nextInt();
    					 dscthd[i].setSoluong(soluongmoi);
    				 }
    				 if(luachon==4)
    				 {
    					 System.out.println("\nMoi ban nhap don gia moi: ");
    					 dongiamoi=in.nextInt();
    					 dscthd[i].setDongia(dongiamoi);
    				 }
    				 if(luachon==5)
    				 {
    					 System.out.println("\nBan da thoat sua thanh cong. ");
    					 break;
    				 }
    			 }
    		 }
    	 }
    
    }
    public  void Ghifile(String filename) throws FileNotFoundException, IOException{
        DataOutputStream outstream = new DataOutputStream(new FileOutputStream(filename));
        for(int i = 0 ; i < n ; i ++)
        {
            dscthd[i].Ghifile(filename);
        }
        outstream.close();
    }
    public void Docfile(String filename) throws FileNotFoundException, IOException{
        int i = 0 ; 
        n = 0;
        try{
            DataInputStream instream = new DataInputStream(new FileInputStream(filename));
            try{
            while(true){
                String idhoadon = instream.readUTF();
                String idsach = instream.readUTF();
                int soluong = instream.readInt();
                float dongia = instream.readFloat();
                float thanhtien = instream.readFloat();
                dscthd = Arrays.copyOf(dscthd,n+1);
                dscthd[i] = new Chitiethoadon(idhoadon,idsach,soluong,dongia,thanhtien);
                i++;
                n++;
            }
            
        }catch(EOFException e){
            }
         finally{
                instream.close();
            }
        }
       catch(FileNotFoundException e){
               System.out.println("IOERROR"+filename+"NOT FOUND");
               }
       catch(IOException e){
               System.out.println("IOERROR"+e.getMessage()+"\n");
               }
        }
	@Override
	public void Themk(int k) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Suatheoma(String ms) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Timkiemtheoma(String ma) {
		// TODO Auto-generated method stub
		
	}

 
 }

  