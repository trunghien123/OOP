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

public class Danhsachloaigiamgia {
 private int n;
 private Loaigiamgia [] dslgg =new Loaigiamgia[1];
 public Danhsachloaigiamgia() {}
 public Danhsachloaigiamgia(Loaigiamgia [] a,int n)
 {
	 this.n=n;
	 this.dslgg=Arrays.copyOf(a, n);
 }
 public Danhsachloaigiamgia(Danhsachloaigiamgia lgg)
 {
	 this.n=lgg.n;
	 this.dslgg=Arrays.copyOf(lgg.dslgg, n);
 }
 public void Nhap()
 {
	 Scanner in = new Scanner(System.in);
	 System.out.println("Nhap vao so luong loai giam gia: ");
	 this.n=in.nextInt();
	 dslgg = Arrays.copyOf(dslgg, n);
	 for(int i=0; i<n ; i++)
	 {
		 dslgg[i] = new Loaigiamgia();
		 dslgg[i].Nhap();
	 }
 }
 public void Xuat()
 {
	 System.out.printf("\n%-100s","______________________________________");
     System.out.printf("\n|%-20s|","Sophantram");
     System.out.printf("\n|%-100s","--------------------------------------");
     for(int i=0;i<n;i++)
     {
         dslgg[i].Xuat();
         System.out.printf("\n|%-100s","----------------------------------------------");
     }
 }
 public void Them()
 {
	 dslgg= Arrays.copyOf(dslgg, n+1);
	 dslgg[n]= new Loaigiamgia();
	 dslgg[n].Nhap();
	 n++;
 }
//Them nhieu loai giam gia
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
 public void xoavt(int vitrixoa)
 {
	 for(int i=vitrixoa;i<n-1;i++)
	 {
		 dslgg[i]= dslgg[i+1];
	 }
	 dslgg = Arrays.copyOf(dslgg, n-1);
	 n--;
 }
 public void Xoatheosophantram()
 {
	 float x;
	 System.out.println("\nNhap vao so phan tram se xoa: ");
	 Scanner in = new Scanner(System.in);
	 x=in.nextFloat();
	 for(int i=0;i<n;i++)
	 {
		 if(dslgg[i].getSophantram()==x)
		 {
			 xoavt(i);
		 }
	 }
 }
 public void Timkiem()
 {
	 float search;
	 System.out.println("\nNhap vao so phan tram: ");
	 Scanner in = new Scanner(System.in);
	 search = in.nextFloat();
	 System.out.printf("\n%-100s","______________________________________");
     System.out.printf("\n|%-20s|","Sophantram");
     System.out.printf("\n|%-100s","--------------------------------------");
	 for(int i=0;i<n;i++)
	 {
		 if( dslgg[i].getSophantram()==search)
		 {
			 dslgg[i].Xuat();
			 System.out.printf("\n|%-100s","----------------------------------------------");
		 }		 
	 }
 }
 public void Sua()
 {
	 float sophantrammoi;
	 float sophantram;
	 Scanner in = new Scanner(System.in);
	 System.out.println("\nNhap vao so phan tram can sua: ");
	 sophantram=in.nextFloat();
	 System.out.println("\nNhap vao so phan tram moi: ");
	 sophantrammoi = in.nextFloat();
	 for(int i=0;i<n;i++)
	 {
		 if(dslgg[i].getSophantram()==sophantram)
		 {
			 dslgg[i].setSophantram(sophantrammoi);
		 }
	 }
 }
 public void ghifile(String filename) throws FileNotFoundException, IOException
 {
	 DataOutputStream outstream = new DataOutputStream(new FileOutputStream(filename));
	 for(int i=0;i<n;i++)
	 {
		 dslgg[i].Ghifile(filename);
	 }
	 outstream.close();
 }
 public void docfile(String filename)
 {
	 int i=0;
	 int n=0;
	 try {
		 DataInputStream instream = new DataInputStream(new FileInputStream(filename));
		 try {
			 while(true)
			 {
				 Float sophantram = instream.readFloat();
				 dslgg=Arrays.copyOf(dslgg, n+1);
				 dslgg[i] = new Loaigiamgia(sophantram);
				 i++;
				 n++;
			 }
		 }catch(EOFException e) {}
		 finally
		 {
			 instream.close();
		 }
	 }catch(FileNotFoundException e)
	 {
		 System.out.println("IOERROR: "+filename+"Not Found:");
	 }
	 catch(IOException e)
	 {
		 System.out.println("IOERROR: "+e.getMessage()+"\n");
	 }
 }
}
