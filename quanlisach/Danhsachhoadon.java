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
import java.util.Arrays;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Danhsachhoadon {
    private Hoadon [] dshd = new Hoadon[1];
    private int n; 
    private int i;
    public Danhsachhoadon(){
    }
    public Danhsachhoadon(int n, Hoadon [] a)
    {
       this.n = n;
       this.dshd = Arrays.copyOf(a,n);
    }
    public Danhsachhoadon (Danhsachhoadon ds)
    {
        this.n = ds.n; 
        this.dshd = Arrays.copyOf(ds.dshd,n);
    }
    public void Nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong hoa don:");
        this.n = sc.nextInt();
        dshd = Arrays.copyOf(dshd, n);
        for(int i=0; i<n; i++)
        {
            dshd[i] = new Hoadon();
            dshd[i].nhap();
        }
    }
    public void Xuat()
    {
    	System.out.printf("\n%-100s","______________________________________________________________________________________________________________________________________________________");
    	System.out.printf("\n|%-15s|%-15s|%-15s|%-15s|%-15s|","Mahoadon","Makhachhang","Manhanvien","Ngaylaphoadon","Tongtien");
		System.out.printf("\n|%-100s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
		for(int i=0;i<n;i++)
		{
			dshd[i].Xuat();
			System.out.printf("\n|%-10s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
		}
    }
    
    public void Xoavt(int vitrixoa)
    {
        for(int i = vitrixoa; i<n-1; i++)
        {
            dshd[i] = dshd[i+1]; 
        }
        dshd = Arrays.copyOf(dshd, n-1);
        n--;
    }
    public void Xoatheoma(String ma)
    {
        for(int i =0; i<n; i++)
        {
            if(dshd[i].getMahoadon().equals(ma))
            {
                Xoavt(i);
            }
        }
    }
    public void Them()
    {
      dshd = Arrays.copyOf(dshd, n+1);
      dshd[n] =new Hoadon();
      dshd[n].nhap();
      n++;
    }
  //Them nhieu hoa don
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
	   System.out.println("\nMoi ban nhap vao ma can tim kiem: ");
	   Scanner in =new Scanner(System.in);
	   ma= in.nextLine();
	   	System.out.printf("\n%-100s","______________________________________________________________________________________________________________________________________________________");
   		System.out.printf("\n|%-15s|%-15s|%-15s|%-15s|%-15s|","Mahoadon","Makhachhang","Manhanvien","Ngaylaphoadon","Tongtien");
		System.out.printf("\n|%-100s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
       for(int i = 0 ; i < n ; i++)
       {
           if(dshd[i].getMahoadon().equals(ma))
           {
               dshd[i].Xuat();
               System.out.printf("\n|%-10s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
           }
       }
   }
   public void Suatheoma()
    {
	   String ma;
	   Scanner in = new Scanner(System.in);
	   System.out.println("\nNhap vao ma can sua: ");
	   ma = in.nextLine();
        for(int i = 0 ; i < n ; i++)
        {
            if(dshd[i].getMahoadon().equals(ma))
            {
                int luachon;
                while(true)
                {
                    System.out.println("\n1.Sua ma hoa don ");
                    System.out.println("2.Sua ma khach hang ");
                    System.out.println("3.Sua ma nhan vien ");
                    System.out.println("4.Sua ngay lap hoa don ");
                    System.out.println("5.Thoat");
                    System.out.println("Moi ban nhap lua chon ");
                    luachon = in.nextInt();
                    in.nextLine();
                    if(luachon == 1)
                    {
                        String mamoi;
                        System.out.println("Nhap ma hoa don moi ");
                        mamoi = in.nextLine();
                        dshd[i].setMahoadon(mamoi);
                    }
                    else if (luachon == 2)
                    {
                        String makhachhang;
                        System.out.println("Nhap vao ma khach hang moi ");
                        makhachhang = in.nextLine();
                        dshd[i].setMakhachhang(makhachhang);
                    }
                    else if(luachon == 3)
                    {
                        String manhanvien;
                        System.out.println("Nhap vao ma nhan vien moi ");
                        manhanvien = in.nextLine();
                        dshd[i].setManhanvien(manhanvien);
                    }
                    else if (luachon == 4)
                    {
                        String ngaylaphoadon;
                        System.out.println("Nhap vao ngay lap hoa don moi ");
                        ngaylaphoadon = in.nextLine();
                        dshd[i].setNgaylaphoadon(ngaylaphoadon);
                    }
                    else if(luachon==5)
                    {
                        break;
                    }
                    
                }
            }
        }
    }
   public void Ghifile(String filename) throws FileNotFoundException, IOException{
       DataOutputStream outstream = new DataOutputStream(new FileOutputStream(filename));
       for(int i = 0 ; i < n ; i++)
       {
           dshd[i].Ghifile(filename);
       }
       outstream.close();
   }
   public void Docfile(String filename) throws IOException
   {
       int i = 0; 
       n = 0;
        try{
            DataInputStream instream = new DataInputStream(new FileInputStream(filename));
            try{
                while(true){
                    String id_hd  = instream.readUTF();
                    String id_kh = instream.readUTF();
                    String id_nv = instream.readUTF();
                    String date  = instream.readUTF();
                    dshd = Arrays.copyOf(dshd,n+1);
                    dshd[i] = new Hoadon(id_hd,id_kh,id_nv,date);
                    i++;
                    n++;
                }
            }
            catch(EOFException e){
                
            }
            finally{
                instream.close();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("IOERROR "+filename +"not found");
        }
        catch(IOException a){
            System.out.println("IOERROR "+a.getMessage()+"\n");
        }
    }
    
}
