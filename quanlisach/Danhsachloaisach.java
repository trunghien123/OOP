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
public class Danhsachloaisach {
    private int n;
    private Loaisach[] dsls=new Loaisach[1];
    public Danhsachloaisach()
    {
        
    }
    public Danhsachloaisach(int n,Loaisach[] dsls)
    {
        this.n=n;
        dsls=Arrays.copyOf(dsls,n);
    }
    public Danhsachloaisach(Danhsachloaisach dsls)
    {
        n=dsls.n;
        this.dsls=Arrays.copyOf(dsls.dsls, n);
    }
    public void Nhap()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Moi ban Nhap so loai sach: ");
        n=sc.nextInt();
        dsls=Arrays.copyOf(dsls, n);
        for(int i=0;i<n;i++)
        {
            dsls[i]=new Loaisach();
            dsls[i].Nhap();
        }
        
    }
    public void Xuat()
    {
        System.out.printf("%-40s","_______________________________________________________________________________________________________");
        System.out.printf("\n|%-50s|%-50s|","Ma The Loai","Ten The Loai");
        System.out.printf("\n%-40s","-----------------------------------------------------------------------------------------------------");
        for(int i=0;i<n;i++)
        {
            dsls[i].Xuat();
            System.out.printf("\n%-40s","-----------------------------------------------------------------------------------------------------");
        }
        
    }
    public void Them()
    {
        dsls=Arrays.copyOf(dsls,n+1);
        dsls[n]=new Loaisach();
        dsls[n].Nhap();
        n++;
        
    }
  //Them nhieu loai sach
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
    public void Xoavt(int vitrixoa)
    {
        for(int i=vitrixoa;i<n-1;i++)
        {
            dsls[i]=dsls[i+1];
        }
        n--;
    }
    public void Xoatheoma(String ma)
    {
    	for(int i=0;i<n;i++)
        {
            if(dsls[i].getMaloai().equals(ma))
            {
                Xoavt(i);
            }
        }
    }
    public void Timkiemtheoma()
    {
    	String ma;
    	Scanner in = new Scanner(System.in);
    	System.out.println("\nNhap vao ma can tim kiem: ");
    	ma = in.nextLine();
    	System.out.printf("%-40s","_______________________________________________________________________________________________________");
        System.out.printf("\n|%-50s|%-50s|","Ma The Loai","Ten The Loai");
        System.out.printf("\n%-40s","-----------------------------------------------------------------------------------------------------");
        for(int i=0;i<n;i++)
        {
            if(dsls[i].getMaloai().equals(ma))
            {
                dsls[i].Xuat();
                System.out.printf("\n%-40s","-----------------------------------------------------------------------------------------------------");
            }
        }
    }
    public int Thongketheoten(String ten)
    {
        int dem=0;
        for(int i=0;i<n;i++)
        {
            if(dsls[i].getTenloai().equalsIgnoreCase(ten))
                dem++;
            
        }
        return dem;
    }
    public void Suatheoma(String ma)
    {
        Scanner sc=new Scanner(System.in);
        String maloaimoi;
        String tenloaimoi;
        for(int i=0;i<n;i++)
        {
            if(dsls[i].getMaloai().equals(ma))
            {
                int luachon;
                while(true)
                {
                    System.out.println("\n1.Sua ma loai.");
                    System.out.println("\n2.Sua ten loai.");
                    System.out.println("\n3.Thoat");
                    System.out.println("\nMoi ban Nhap lua chon: ");
                    luachon=sc.nextInt();
                    sc.nextLine();
                    if(luachon==1)
                    {
                        System.out.println("\nMoi ban Nhap ma moi:");
                        maloaimoi=sc.nextLine();
                        dsls[i].setMaloai(maloaimoi);
                    }
                    if(luachon==2)
                    {
                        System.out.println("\nMoi ban Nhap the loai moi:");
                        tenloaimoi=sc.nextLine();
                        dsls[i].setTenloai(tenloaimoi);
                    }
                    if(luachon==3)
                    {
                        break;
                    }
                }
            }
        }
    }
    public void ghifile(String filename) throws FileNotFoundException, IOException
    {
        DataOutputStream outstream=new DataOutputStream(new FileOutputStream(filename));
        for(int i=0;i<n;i++)
        {
            dsls[i].ghifile(filename);
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
                while(true){
                String maloai=instream.readUTF();
                String tenloai=instream.readUTF();
                dsls=Arrays.copyOf(dsls,n+1);
                dsls[i]=new Loaisach(maloai,tenloai);
                i++;
                n++;
            }
            }catch(EOFException a){
            }finally{
                    instream.close();
                    }
        }catch(FileNotFoundException e){
            System.out.println("IOEROR: "+filename+"Not Found:\n");
        }catch(IOException e){
            System.out.println("IOEror:"+e.getMessage()+"\n");
        }
    }
    
    
}
