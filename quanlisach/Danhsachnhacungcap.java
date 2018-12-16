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
public class Danhsachnhacungcap {
    private int n ;
    private Nhacungcap[] dsncc = new Nhacungcap[1];
    public Danhsachnhacungcap(){
    }
    public Danhsachnhacungcap(Nhacungcap[] a,int n){
        this.n = n;
        this.dsncc = Arrays.copyOf(a, n);
    }
    public Danhsachnhacungcap(Danhsachnhacungcap ds){
        this.n = ds.n;
        this.dsncc = Arrays.copyOf(ds.dsncc,n);
    }
    public void Nhapdanhsachnhacungcap(){
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap vao so luong nha cung cap :");
        this.n = in.nextInt();
        dsncc = Arrays.copyOf(dsncc,n);
        for(int i = 0 ; i < n ; i++)
        {
            dsncc[i] = new Nhacungcap();
            dsncc[i].Nhap();
        }
        
    }
    public void Xuatdanhsachnhacungcap(){
    	System.out.printf("\n%-100s","______________________________________________________________________________________________________________________________________________________");
    	System.out.printf("\n|%-15s|%-15s|%-10s|%-10s|","manhacungcap","tennhacungcap","diachi","dienthoai");
		System.out.printf("\n|%-100s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
         for(int i = 0 ; i < n ; i++)
        {
            dsncc[i].Xuat();
            System.out.printf("\n|%-10s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
            
        }
    }
    public void Xoavt(int vitrixoa){
        for(int i = vitrixoa ; i < n -1 ; i++)
        {
            dsncc[i] = dsncc[i+1];
        }
        dsncc = Arrays.copyOf(dsncc,n-1);
        n--;
    }
    public void Xoatheoma(String ma){
        for(int i = 0 ; i < n ; i++)
        {
            if(dsncc[i].getManhacungcap().equals(ma))
            {
                Xoavt(i);
            }
        }
    }
    public void Them(){
        dsncc = Arrays.copyOf(dsncc,n+1);
        dsncc[n] = new Nhacungcap();
        dsncc[n].Nhap();
        n++;
    }
  //Them nhieu nha cung cap
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
	   String manccmoi;
	   String tennccmoi;
	   String diachimoi;
	   String dienthoaimoi;
	   for(int i=0;i<n;i++)
	   {
		   int luachon;
		   if(dsncc[i].getManhacungcap().equals(ma))
		   {
			   while(true)
			   {
				   System.out.println("\n1.Sua ma nha cung cap.");
				   System.out.println("\n2.Sua ten nha cung cap.");
				   System.out.println("\n3.Sua dia chi nha cung cap.");
				   System.out.println("\n4.Sua dien thoai nha cung cap.");
				   System.out.println("\n5.Thoat.");
				   System.out.println("\nMoi ban nhap vao lua chon: ");
				   luachon=in.nextInt();
				   in.nextLine();
				   if(luachon<1||luachon>5)
				   {
					   System.out.println("Ban da nhap sai lua chon!!!");
				   }
				   if(luachon==1)
				   {
					   System.out.println("\nMoi ban nhap vao ma nha cung cap moi: ");
					   manccmoi= in.nextLine();
					   dsncc[i].setManhacungcap(manccmoi);
				   }
				   if(luachon==2)
				   {
					   System.out.println("\nMoi ban nhap vao ten nha cung cap moi: ");
					   tennccmoi= in.nextLine();
					   dsncc[i].setTennhacungcap(tennccmoi);
				   }
				   if(luachon==3)
				   {
					   System.out.println("\nMoi ban nhap vao dia chi moi: ");
					   diachimoi= in.nextLine();
					   dsncc[i].setDiachi(diachimoi);
				   }
				   if(luachon==4)
				   {
					   System.out.println("\nMoi ban nhap vao dien thoai moi: ");
					   dienthoaimoi= in.nextLine();
					   dsncc[i].setDienthoai(dienthoaimoi);
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
   public void Timkiemnhacungcap()
   {
	   String ma;
	   System.out.println("\nNhap vao ma can tim kiem: ");
	   Scanner in = new Scanner(System.in);
		ma = in.nextLine();
	   	System.out.printf("\n%-100s","______________________________________________________________________________________________________________________________________________________");
   		System.out.printf("\n|%-15s|%-15s|%-10s|%-10s|","manhacungcap","tennhacungcap","diachi","dienthoai");
		System.out.printf("\n|%-100s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
       for(int i = 0 ; i < n ; i++)
       {
           if(dsncc[i].getManhacungcap().equals(ma))
           {
              dsncc[i].Xuat();
              System.out.printf("\n|%-10s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
           }
       }
   }
   public void Ghifile(String filename) throws FileNotFoundException, IOException{
       DataOutputStream outstream = new DataOutputStream(new FileOutputStream(filename));
       for(int i = 0 ; i < n ; i++)
       {
           dsncc[i].Ghifile(filename);
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
                    String id = instream.readUTF();
                    String name = instream.readUTF();
                    String address = instream.readUTF();
                    String phone = instream.readUTF();
                    dsncc = Arrays.copyOf(dsncc,n+1);
                    dsncc[i] = new Nhacungcap(id,name,address,phone);
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
