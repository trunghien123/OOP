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

public class Danhsachthongtingiamgia {
 private Thongtingiamgia [] dsttgg = new Thongtingiamgia[1];
 private int n;
 public Danhsachthongtingiamgia() {}
 public Danhsachthongtingiamgia(int n, Thongtingiamgia [] a)
 {
	 this.n=n;
	 this.dsttgg=Arrays.copyOf(a,n);
 }
 public Danhsachthongtingiamgia(Danhsachthongtingiamgia ttgg)
 {
	 this.n=ttgg.n;
	 this.dsttgg = Arrays.copyOf(ttgg.dsttgg, n);
 }
 public void Nhap()
 {
	 Scanner in = new Scanner(System.in);
	 System.out.println("Nhap vao so luong thong tin giam gia: ");
	 this.n= in.nextInt();
	 dsttgg = Arrays.copyOf(dsttgg, n);
	 for(int i=0 ; i<n;i++)
	 {
		 dsttgg[i] = new Thongtingiamgia();
		 dsttgg[i].Nhap();
	 }
 }
 public void Xuat()
 {
	 System.out.printf("\n|%-100s","________________________________________________________________________________________________");
	 System.out.printf("\n|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|","Magiamgia","Masach","Dotgiamgia","Batdau","Ketthuc","Maloaigiamgia");
	 System.out.printf("\n|%-100s","------------------------------------------------------------------------------------------------");
	for(int i=0;i<n;i++)
	{
		dsttgg[i].Xuat();
		System.out.printf("\n|%-100s","------------------------------------------------------------------------------------------------");
	}
 }
 public void xoavt(int vitrixoa)
 {
	 for(int i=vitrixoa; i<n-1; i++)
	 {
		 dsttgg[i] = dsttgg[i+1];
	 }
	 dsttgg = Arrays.copyOf(dsttgg, n-1);
	 n--;
 }
 public void xoatheoma(String ma)
 {
	 for(int i=0; i<n;i++)
	 {
		 if(dsttgg[i].getMagiamgia().equals(ma))
		 {
			 xoavt(i);
		 }
	 }
 }
 public void Them()
 {
	 dsttgg = Arrays.copyOf(dsttgg, n+1);
	 dsttgg[n] = new Thongtingiamgia();
	 dsttgg[n].Nhap();
	 n++;
 }
 public void Themk(int k)
 {
	 for(int i=0 ; i<k;i++)
	 {
		 Them();
	 }
 }
 public void Timkiemtheoma(String ma)
 {
	 for(int i=0 ; i<n ;i++)
	 {
		 if(dsttgg[i].getMagiamgia().equals(ma));
		 {
			 dsttgg[i].Xuat();
		 }
	 }
 }
 public void ghifile(String filename) throws FileNotFoundException, IOException
 {
	 DataOutputStream outstream = new DataOutputStream(new FileOutputStream(filename));
	 for(int i=0;i<n ;i++)
	 {
		 dsttgg[i].Ghifile(filename);
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
				 String magiamgia = instream.readUTF();
				 String masach = instream.readUTF();
				 String dotgiamgia = instream.readUTF();
				 String batdau = instream.readUTF();
				 String ketthuc = instream.readUTF();
				 String maloaigiamgia = instream.readUTF();
				 dsttgg = Arrays.copyOf(dsttgg, n+1);
				 dsttgg[i] = new Thongtingiamgia(magiamgia,masach,dotgiamgia,batdau,ketthuc,maloaigiamgia);
				 i++;
				 n++;
			 }
		 }catch(EOFException e) {}
		 finally {
			 instream.close();
		 }
	 }catch(FileNotFoundException e)
	 {
		 System.out.println("IOEROR: "+filename+"Not Found: ");
	 }catch(IOException e)
	 {
		 System.out.println("IOERROR: "+e.getMessage()+"\n");
	 }
 }
}
