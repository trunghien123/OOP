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
public class Danhsachkhachhang {
    private Khachhang [] dskh = new Khachhang[1];
    private int n; 
    private int i;
    public Danhsachkhachhang(){
    }
    public Danhsachkhachhang(int n, Khachhang [] a)
    {
       this.n = n;
       this.dskh = Arrays.copyOf(a,n);
    }
    public Danhsachkhachhang (Danhsachkhachhang ds)
    {
        this.n = ds.n; 
        this.dskh = Arrays.copyOf(ds.dskh,n);
    }
    public void Nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong khach hang:");
        this.n = sc.nextInt();
        dskh = Arrays.copyOf(dskh, n);
        for(int i=0; i<n; i++)
            
        {
            dskh[i] = new Khachhang();
            dskh[i].Nhap();
        }
    }
    public void Xuat()
    {
    	System.out.printf("\n%-100s","______________________________________________________________________________________________________________________________________________________");
    	System.out.printf("\n|%-15s|%-15s|%-15s|%-15s|%-15s","makhachhang","hokhachhang","hokhachhang","diachi","dienthoai");
		System.out.printf("\n|%-100s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
		for(int i=0;i<n;i++)
		{
			dskh[i].Xuat();
			System.out.printf("\n|%-10s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
		}
    }
    
    public void ghifile(String filename) throws FileNotFoundException, IOException
        {
                        DataOutputStream outstream=new DataOutputStream(new FileOutputStream(filename));
                        for(int i=0; i<n; i++)
                        {
                            dskh[i].Ghifile(filename);
                        }
                        outstream.close();
        }
        public void docfile(String filename) throws IOException
        {
            int n=0, i=0;
            try{
                DataInputStream inStream = new DataInputStream(new FileInputStream(filename));
                try{
                    while(true)
                    {
                        
                        String Makhachhang=inStream.readUTF();
                        String Hokhachhang=inStream.readUTF();
                        String Tenkhachhang=inStream.readUTF();
                        String Diachi=inStream.readUTF();
                        String Dienthoai=inStream.readUTF();
                        dskh=Arrays.copyOf(dskh, n+1);
                        dskh[i]=new Khachhang(Makhachhang,Hokhachhang,Tenkhachhang,Diachi,Dienthoai);
                        i++;
                        n++;
                    }
                }
                catch(EOFException e){}
                finally{
                    inStream.close();
                }
            }catch(FileNotFoundException e)
            {
                System.out.println("IOERROR:"+filename+"Not Found:");
            }
            catch(IOException e){
                System.out.println("IOERROR:"+e.getMessage()+"\n");
            }
        }
    public void Xoavt(int vitrixoa)
    {
        for(int i = vitrixoa; i<n-1; i++)
        {
            dskh[i] = dskh[i+1]; 
        }
        dskh = Arrays.copyOf(dskh, n-1);
        n--;
    }
    public void Xoatheoma(String ma)
    {
        for(int i =0; i<n; i++)
        {
            if(dskh[i].getMakhachhang().equals(ma))
            {
                Xoavt(i);
            }
        }
    }
    public void Them()
    {
      dskh = Arrays.copyOf(dskh, n+1);
      dskh[n] =new Khachhang();
      dskh[n].Nhap();
      n++;
    }
    public void Themk(int k)
    {
        for(int i=0; i<k; i++)
        {
            Them();
        }
    }
   public void Timkiemtheoma(String ma)
   {
       for(int i = 0 ; i < n ; i++)
       {
           if(dskh[i].getMakhachhang().equals(ma))
           {
               System.out.println(dskh[i].toString());
           }
       }
   }
}
