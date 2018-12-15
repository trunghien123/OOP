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
        for(int i=0; i<n; i++)
            dsnv = Arrays.copyOf(dsnv, n);
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
    public void Themk(int k)
    {
        for(int i=0; i<k; i++)
        {
            Them();
        }
    }
     public void Sapxeptheoma(){
        for(int i = 0 ; i < n-1 ; i++)
        {
            for(int j = i + 1 ; j < n ; j++)
            {
                if(dsnv[i].getManhanvien().compareToIgnoreCase(dsnv[j].getManhanvien())> 0)
                {
                    Nhanvien a = new Nhanvien(dsnv[i]);
                    dsnv[i] = dsnv[j];
                    dsnv[j] = a;
                  
                }
            }
        }
    }
     
   public void Timkiemtheoma(String ma)
   {
       for(int i = 0 ; i < n ; i++)
       {
           if(dsnv[i].getManhanvien().equals(ma))
           {
               System.out.println(dsnv[i].toString());
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
    