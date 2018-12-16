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
import java.util.Arrays;
import java.util.Scanner;

public class Danhsachnhanvien {
    private Nhanvien [] dsnv = new Nhanvien[1];
    private int n; 
    private int i;
    public Danhsachnhanvien(){
    }
    public Danhsachnhanvien(int n, Nhanvien [] a)
    {
       this.n = n;
       this.dsnv = Arrays.copyOf(a,n);
    }
    public Danhsachnhanvien (Danhsachnhanvien ds)
    {
        this.n = ds.n; 
        this.dsnv = Arrays.copyOf(ds.dsnv,n);
    }
    public void Nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong nhan vien:");
        this.n = sc.nextInt();
        dsnv = Arrays.copyOf(dsnv, n);
        for(int i=0; i<n; i++) 
        {
            dsnv[i] = new Nhanvien();
            dsnv[i].Nhap();
        }
    }
    public void Xuat()
    {
    	System.out.printf("\n%-100s","______________________________________________________________________________________________________________________________________________________");
    	System.out.printf("\n|%-13s|%-13s|%-13s|%-10s|","manhanvien","tennhanvien","ngaysinh","luong");
		System.out.printf("\n|%-100s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
		for(int i=0;i<n;i++)
		{
			dsnv[i].Xuat();
			System.out.printf("\n|%-10s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
		}
    }
    
    public void xoavt(int vitrixoa)
    {
        for(int i = vitrixoa; i<n-1; i++)
        {
            dsnv[i] = dsnv[i+1]; 
        }
        dsnv = Arrays.copyOf(dsnv, n-1);
        n--;
    }
    public void Xoatheoma(String ma)
    {
        for(int i =0; i<n; i++)
        {
            if(dsnv[i].getManhanvien().equals(ma))
            {
                xoavt(i);
            }
        }
    }
    public void Them()
    {
      dsnv = Arrays.copyOf(dsnv, n+1);
      dsnv[n] =new Nhanvien();
      dsnv[n].Nhap();
      n++;
    }
  //Them nhieu nhan vien
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
    	Scanner in = new Scanner(System.in);
    	System.out.println("\nNhap vao ma can sua: ");
    	ma = in.nextLine();
    	String manhanvienmoi;
    	String tennhanvienmoi;
    	String ngaysinhmoi;
    	String luongmoi;
    	for(int i=0;i < n ;i++)
    	{
    		if(dsnv[i].getManhanvien().equals(ma))
    		{
    			int luachon;
	    		while(true)
	    		{
	    			System.out.println("\n1.Sua ma nhan vien.");
	    			System.out.println("\n2.Sua ten nhan vien.");
	    			System.out.println("\n3.Sua ngay sinh.");
	    			System.out.println("\n4.Sua luong.");
	    			System.out.println("\n5.Thoat.");
	    			luachon=in.nextInt();
	    			in.nextLine();
	    			if(luachon<1 || luachon>5)
	    			{
	    				System.out.println("Ban da nhap sai lua chon.!!!");
	    			}
	    			if(luachon==1)
	    			{
	    				System.out.println("\nNhap vao ma nhan vien moi: ");
	    				manhanvienmoi = in.nextLine();
	    				dsnv[i].setManhanvien(manhanvienmoi);
	    			}
	    			if(luachon==2)
	    			{
	    				System.out.println("\nNhap vao ten nhan vien moi: ");
	    				tennhanvienmoi = in.nextLine();
	    				dsnv[i].setTennhanvien(tennhanvienmoi);
	    			}
	    			if(luachon==3)
	    			{
	    				System.out.println("\nNhap vao ngay sinh moi: ");
	    				ngaysinhmoi = in.nextLine();
	    				dsnv[i].setNgaysinh(ngaysinhmoi);
	    			}
	    			if(luachon==4)
	    			{
	    				System.out.println("\nNhap vao luong moi: ");
	    				luongmoi = in.nextLine();
	    				dsnv[i].setLuong(luongmoi);
	    			}
	    			if(luachon==1)
	    			{
	    				System.out.println("\nNhap vao ma nhan vien moi: ");
	    				manhanvienmoi = in.nextLine();
	    				dsnv[i].setManhanvien(manhanvienmoi);
	    			}
	    		}
    		}
    	}
    }
   public void Timkiemtheoma()
   {
	   String ma;
	   Scanner in = new Scanner(System.in);
	   System.out.println("\nNhap vao ma can tim kiem: ");
	   ma = in.nextLine();
	   System.out.printf("\n%-100s","______________________________________________________________________________________________________________________________________________________");
	   System.out.printf("\n|%-13s|%-13s|%-13s|%-10s|","manhanvien","tennhanvien","ngaysinh","luong");
		System.out.printf("\n|%-100s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
       for(int i = 0 ; i < n ; i++)
       {
           if(dsnv[i].getManhanvien().equals(ma))
           {
        	   dsnv[i].Xuat();
        	   System.out.printf("\n|%-10s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
           }
       }
   }
   public void ghifile(String filename) throws FileNotFoundException, IOException
   {
       DataOutputStream outstream=new DataOutputStream(new FileOutputStream(filename));
       for(int i = 0; i < n ; i++)
       {
           dsnv[i].Ghifile(filename);
       }
       outstream.close();
   }
   public void docfile(String filename)
   {
       int i=0;
       int n=0;
       try{
           DataInputStream instream=new DataInputStream(new FileInputStream(filename));
           try{
               while(true)
               {
                   String manhanvien=instream.readUTF();
                   String tennhanvien=instream.readUTF();
                   String ngaysinh=instream.readUTF();
                   String luong=instream.readUTF();
                   dsnv=Arrays.copyOf(dsnv, n+1);
                   dsnv[i]=new Nhanvien(manhanvien,tennhanvien,ngaysinh,luong);
                   i++;
                   n++;
               }
           }catch(EOFException e){
               
           }finally{
               instream.close();
           }
       }catch(FileNotFoundException e)
       {
           System.out.println("IOERROR:"+filename+"Not Found:");
       }catch(IOException e)
       {
           System.out.println("IOERROR:"+e.getMessage()+"\n");
       }
   }
}
    